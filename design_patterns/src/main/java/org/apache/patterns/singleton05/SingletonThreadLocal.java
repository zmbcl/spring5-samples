package org.apache.patterns.singleton05;

import org.apache.patterns.singleton04.SingletonContainer;

/**
 * @Auther: bcl
 * @Description: 线程单例实现
 * @Date: Create in 9:43 上午 2020/4/20
 * ThreadLocal不能保证其创建的对象式全局唯一的，但是能保证在单个线程中式唯一的，天生式线程安全的
 */
public class SingletonThreadLocal {
    private static final ThreadLocal<SingletonThreadLocal> THREAD_LOCAL = new ThreadLocal<SingletonThreadLocal>() {
        @Override
        protected SingletonThreadLocal initialValue() {
            return new SingletonThreadLocal();
        }
    };

    private SingletonThreadLocal() {
    }

    public static SingletonThreadLocal getInstance() {
        return THREAD_LOCAL.get();
    }
}
