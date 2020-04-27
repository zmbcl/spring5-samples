package org.apache.patterns.decorator01;

/**
 * @Auther: bcl
 * @Description: 拓展套餐的抽象装饰类
 * @Date: Create in 9:09 下午 2020/4/27
 */
public abstract class BattercakeDecorator extends Battercake {
    // 静态代理，委派
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
