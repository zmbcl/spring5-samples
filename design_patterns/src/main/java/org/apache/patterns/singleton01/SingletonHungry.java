package org.apache.patterns.singleton01;

/**
 * @Auther: bcl
 * @Description: 饿汉式单例模式：类加载时立即初始化，并且创建单例对象，绝对线程安全，不存在访问安全问题
 * @Date: Create in 11:38 上午 2020/4/19
 * 优点：没有加任何锁、执行效率比较高，用户体验比懒汉式单例模式更好
 * 缺点：类加载的时候就初始化，不管用不用都占空间，浪费内存
 */
/*
 * ### 第一种写法 ###
public class SingletonHungry {
    private static final SingletonHungry SINGLETON_HUNGRY = new SingletonHungry();

    private SingletonHungry() {
    }
     public static SingletonHungry getInstance(){
        return SINGLETON_HUNGRY;
     }
}*/

public class SingletonHungry {
    private static final SingletonHungry SINGLETON_HUNGRY;

    static {
        SINGLETON_HUNGRY = new SingletonHungry();
    }

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return SINGLETON_HUNGRY;
    }
}
