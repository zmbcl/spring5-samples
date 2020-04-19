package org.apache.patterns.singleton02;

/**
 * @Auther: bcl
 * @Description: 这种形式兼顾饿汉式单例模式的内存浪费问题和synchronized的性能问题，完全屏蔽了这两个缺点
 * @Date: Create in 1:52 下午 2020/4/19
 */
public class SingletonLazyInnerClass {
    // 默认会先初始化内部类
    // 如果没有使用，则内部类是不加载的
    private SingletonLazyInnerClass() {
    }

    // 每一个关键字都不是多余的，static是为了使单例的空间共享，保证这个方法不会被重写、重载
    public static final SingletonLazyInnerClass getInstance() {
        // 在返回结果以前，一定会先加载内部类
        return LazyHolder.INNER_CLASS;
    }

    // 默认不加载
    private static class LazyHolder {
        private static final SingletonLazyInnerClass INNER_CLASS = new SingletonLazyInnerClass();
    }
}
