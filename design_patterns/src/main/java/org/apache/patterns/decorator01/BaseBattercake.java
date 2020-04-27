package org.apache.patterns.decorator01;

/**
 * @Auther: bcl
 * @Description: 加鸡蛋的煎饼类
 * @Date: Create in 9:03 下午 2020/4/27
 */
public class BaseBattercake extends Battercake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
