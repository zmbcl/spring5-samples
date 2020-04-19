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

    // 用synchronized加锁时，在线程数量比较多的情况下，
    // 如果CPU分配压力上升，则会导致大批线程阻塞，从而导致程序性能大幅下降
    public static SingletonLazySimple getInstance() {
        if (singletonLazySimple == null) {
            synchronized (SingletonLazySimple.class){
                if (singletonLazySimple==null){
                    singletonLazySimple = new SingletonLazySimple();
                }
            }
        }
        return singletonLazySimple;
    }
}
