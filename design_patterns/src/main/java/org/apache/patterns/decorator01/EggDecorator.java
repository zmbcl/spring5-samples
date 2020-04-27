package org.apache.patterns.decorator01;

/**
 * @Auther: bcl
 * @Description: 鸡蛋装饰者类
 * @Date: Create in 9:11 下午 2020/4/27
 */
public class EggDecorator extends BattercakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
