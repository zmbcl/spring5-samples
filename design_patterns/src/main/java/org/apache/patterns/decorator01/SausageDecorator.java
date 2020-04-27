package org.apache.patterns.decorator01;

/**
 * @Auther: bcl
 * @Description: 香肠装饰者类
 * @Date: Create in 9:13 下午 2020/4/27
 */
public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
