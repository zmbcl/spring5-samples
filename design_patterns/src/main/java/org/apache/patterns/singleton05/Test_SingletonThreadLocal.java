package org.apache.patterns.singleton05;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:49 上午 2020/4/20
 */
public class Test_SingletonThreadLocal {
    public static void main(String[] args) {
        System.out.println(SingletonThreadLocal.getInstance());
        System.out.println(SingletonThreadLocal.getInstance());
        System.out.println(SingletonThreadLocal.getInstance());
        System.out.println(SingletonThreadLocal.getInstance());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + SingletonThreadLocal.getInstance());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + SingletonThreadLocal.getInstance());
            }
        }).start();
    }
}
