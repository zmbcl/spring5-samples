package org.apache.patterns.prototype03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: bcl
 * @Description: 饿汉式单例模式：类加载时立即初始化，并且创建单例对象，绝对线程安全，不存在访问安全问题
 * @Date: Create in 11:38 上午 2020/4/19
 */

public class SingletonHungry implements Cloneable {
    private static final SingletonHungry SINGLETON_HUNGRY;
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    static {
        SINGLETON_HUNGRY = new SingletonHungry();
    }

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return SINGLETON_HUNGRY;
    }
    // 保持单例模式克隆
    @Override
    protected SingletonHungry clone() throws CloneNotSupportedException {
        return SINGLETON_HUNGRY;
    }
    // 破坏单例模式克隆
//    @Override
//    protected SingletonHungry clone() throws CloneNotSupportedException {
//        SingletonHungry clone = new SingletonHungry();
//        clone.setList(this.list);
//        return clone;
//    }
}
