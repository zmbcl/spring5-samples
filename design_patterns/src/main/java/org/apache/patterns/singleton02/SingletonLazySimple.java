package org.apache.patterns.singleton02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:46 上午 2020/4/19
 */
public class SingletonLazySimple {
    private SingletonLazySimple() {
    }

    private static SingletonLazySimple singletonLazySimple = null;

    public static SingletonLazySimple getInstance() {
        if (singletonLazySimple == null) {
            singletonLazySimple = new SingletonLazySimple();
        }
        return singletonLazySimple;
    }
}
