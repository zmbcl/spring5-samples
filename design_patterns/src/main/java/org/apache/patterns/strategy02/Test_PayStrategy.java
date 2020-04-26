package org.apache.patterns.strategy02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 5:41 PM 2020/4/26
 */
public class Test_PayStrategy {
    public static void main(String[] args) {
        Order order = new Order("1", "20200426", 700);
        System.out.println(order.pay(PayStrategyType.WETCHAT_PAY));
    }
}
