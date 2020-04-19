package org.apache.patterns.singleton02;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:59 上午 2020/4/19
 */
public class TestLazySimpleSingleton {
    public static void main(String[] args) {
        reflectTest();
    }

    // 单例的线程安全测试
    public static void threadTest(){
        new Thread(new ExectorThread()).start();
        new Thread(new ExectorThread()).start();
        System.out.println("end");
    }

    // 单例的反射破坏单例
    public static void reflectTest(){
        try {
            Class<SingletonLazyInnerClass> aClass = SingletonLazyInnerClass.class;
            // 通过反射获取私有的构造方法
            Constructor<SingletonLazyInnerClass> constructor = aClass.getDeclaredConstructor(null);
            // 强制访问
            constructor.setAccessible(true);
            // 暴力初始化两次
            SingletonLazyInnerClass instance1 = constructor.newInstance();
            SingletonLazyInnerClass instance2 = constructor.newInstance();
            System.out.println(instance1 == instance2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class ExectorThread implements Runnable {

    @Override
    public void run() {
        SingletonLazySimple lazySimple = SingletonLazySimple.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + lazySimple);
    }
}
