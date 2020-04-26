package org.apache.patterns.strategy02;

/**
 * @Auther: bcl
 * @Description: 微信支付类WetchatPay
 * @Date: Create in 5:23 PM 2020/4/26
 */
public class WetchatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 100;
    }
}
