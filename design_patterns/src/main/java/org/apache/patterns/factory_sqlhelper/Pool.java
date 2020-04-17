package org.apache.patterns.factory_sqlhelper;

import com.sun.deploy.util.Property;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: bcl
 * @Description: 自定义连接池
 * @Date: Create in 8:54 上午 2020/4/17
 * getInstance()返回Pool的唯一实例
 * 第一次调用时将执行构造函数，构造函数Pool()调用驱动装载loadDrivers()函数；
 * createPool()函数创建连接池；
 * loadDrivers()装载驱动
 * getConnection()返回一个连接实例
 * getConnection(long time)添加时间限制
 * freeConnection(Connection con)将con连接实例返回连接池
 * getnum()返回空闲连接数
 * getnumActive()返回当前使用的连接数
 */
public abstract class Pool {
    public String propertiesName = "connection-INF.properties";
    private static Pool instance = null;
    protected int maxConnect = 10; // 最大连接数
    protected int normalConnect = 10; // 保持连接数
    protected String driverName = null; // 驱动字符串
    protected Driver driver = null; // 驱动变量

    // 构造函数，不允许非子类访问
    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取配置文件
    private void init() throws IOException {
        InputStream inputStream = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(inputStream);
        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    // 装载和注册所有JDBC驱动程序
    private void loadDrivers(String driverName) {
        String driverClassName = driverName;
        try {
            driver = (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序" + driverClassName);
        } catch (Exception e) {
            System.out.println("无法注册JDBC驱动程序:" + driverClassName + ",错误:" + e);
        }
    }

    // 创建连接池
    public abstract void createPool();

    // 返回数据库连接池Pool实例
    public static synchronized Pool getInstance() {
        if (instance == null) {
            try {
                instance.init();
                instance = (Pool) Class.forName("org.apache.patterns.factory_sqlhelper.Pool").newInstance();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    // 获得一个可用的连接，如果没有则创建一个连接，且小于最大连接连接限制
    public abstract Connection getConnection();

    // 获得一个连接，有时间限制
    public abstract Connection getConnection(long time);

    // 将连接对象返回给连接池
    public abstract Connection freeConnection(Connection connection);

    // 返回当前空闲连接数
    public abstract int getnum();

    // 返回当前工作的连接数
    public abstract int getnumActive();

    protected synchronized void release() {
        try {
            // 撤销驱动
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动程序" + driver.getClass().getName());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("无法撤销JDBC驱动程序的注册：" + driver.getClass().getName());
        }
    }
}
