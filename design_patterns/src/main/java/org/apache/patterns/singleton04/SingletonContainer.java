package org.apache.patterns.singleton04;

import com.sun.tools.javac.code.Attribute;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: bcl
 * @Description: 注册式单例：容器式
 * @Date: Create in 9:37 上午 2020/4/20
 * 容器式单例适用于实例非常多的情况，便于管理，但它式非线程安全的！
 */
public class SingletonContainer {
    private SingletonContainer() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object object = null;
                try {
                    object = Class.forName(className).newInstance();
                    ioc.put(className, object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return object;
            }
            else {
                return ioc.get(className);
            }
        }
    }
}
