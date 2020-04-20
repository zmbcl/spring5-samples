package org.apache.patterns.proxy01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:05 下午 2020/4/20
 */
public class Test_Proxy {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
