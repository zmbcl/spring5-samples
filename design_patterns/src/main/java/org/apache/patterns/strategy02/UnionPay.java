package org.apache.patterns.strategy02;

/**
 * @Auther: bcl
 * @Description: 银联支付类UnionPay
 * @Date: Create in 5:25 PM 2020/4/26
 */
public class UnionPay extends Payment{
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 80;
    }
}
