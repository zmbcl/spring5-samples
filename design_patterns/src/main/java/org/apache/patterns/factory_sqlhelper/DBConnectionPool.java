package org.apache.patterns.factory_sqlhelper;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:27 上午 2020/4/17
 */
public class DBConnectionPool extends Pool {
    private int checkdOut; // 正在使用的连接数
    private Vector<Connection> freeConnections = new Vector<>(); // 存放产生的连接对象容器
    private String password = null; // 密码
    private String url = null; // 连接字符串
    private String userName = null; // 用户名
    private static int num = 0; // 空闲连接数
    private static int numActive = 0; // 当前可用的连接数
    private static DBConnectionPool pool = null; // 连接池实例常量

    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection connection = newConnection();
                if (connection != null) {
                    freeConnections.add(connection); // 向容器添加一个连接对象
                    num++; // 记录总连接数
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void init() throws IOException {
        InputStream inputStream = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.userName = properties.getProperty("userName");
        this.password = properties.getProperty("passWord");
        this.driverName = properties.getProperty("driverName");
        this.url = properties.getProperty("url");
        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    private Connection newConnection() {
        Connection connection = null;
        try {
            if (userName == null) {
                connection = DriverManager.getConnection(url);
            }
            else {
                connection = DriverManager.getConnection(url, userName, password);
            }
            System.out.println("连接池创建一个新的连接");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("无法创建这个URL的连接" + url);
            return null;
        }
        return connection;
    }

    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if (pool != null) {
            System.out.println("创建连接池成功");
        }
        else {
            System.out.println("创建连接池失败");
        }
    }

    @Override
    public synchronized Connection getConnection() {
        Connection connection = null;
        if (freeConnections.size() > 0) {
            num--;
            connection = freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (connection.isClosed()) {
                    System.out.println("从连接池删除一个无效连接");
                    connection = getConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("从连接池中删除一个无效连接");
                connection = getConnection();
            }

        }
        // 没有空闲连接且当前连接小于最大允许值，最大值为0则不限制
        else if (maxConnect == 0 || checkdOut < maxConnect) {
            connection = newConnection();
        }
        if (connection != null) {
            checkdOut++;
        }
        numActive++;
        return connection;
    }

    // 获取一个连接，并加上等待时间限制，单位为毫秒
    @Override
    public synchronized Connection getConnection(long time) {
        long startTime = new Date().getTime();
        Connection connection;
        while ((connection = getConnection()) != null) {
            try {
                wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((new Date().getTime() - startTime) >= time) {
                return null;
            }
        }
        return null;
    }

    // 将连接对象返回给连接池
    @Override
    public synchronized Connection freeConnection(Connection connection) {
        freeConnections.addElement(connection);
        num ++;
        checkdOut--;
        numActive--;
        notify();
        return null;
    }

    @Override
    public int getnum() {
        return num;
    }

    @Override
    public int getnumActive() {
        return numActive;
    }

    public synchronized void release() {
        try {
            Enumeration<Connection> allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()) {
                Connection connection = allConnections.nextElement();
                try {
                    connection.close();
                    num--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池中的连接");
                    e.printStackTrace();
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }

    }

}
