package org.apache.patterns.decorator01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:14 下午 2020/4/27
 */
public class Test_Decorator {
    public static void main(String[] args) {
        Battercake battercake;
        // 买一个煎饼
        battercake = new BaseBattercake();
        // 加一个鸡蛋
        battercake = new EggDecorator(battercake);
        // 再加一个鸡蛋
        battercake = new EggDecorator(battercake);
        // 再加一个香肠
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());
    }
}
