package org.apache.patterns.strategy02;

/**
 * @Auther: bcl
 * @Description: 支付宝支付类AliPay
 * @Date: Create in 5:20 下午 2020/4/26
 */
public class AliPay extends Payment{
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
