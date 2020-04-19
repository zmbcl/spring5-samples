package org.apache.patterns.singleton02;


/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:59 上午 2020/4/19
 */
public class TestLazySimpleSingleton {
    public static void main(String[] args) {
        new Thread(new ExectorThread()).start();
        new Thread(new ExectorThread()).start();
        System.out.println("end");
    }
}

class ExectorThread implements Runnable {

    @Override
    public void run() {
        SingletonLazySimple lazySimple = SingletonLazySimple.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + lazySimple);
    }
}
