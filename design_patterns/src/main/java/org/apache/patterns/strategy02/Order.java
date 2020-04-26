package org.apache.patterns.strategy02;

import com.sun.javafx.tk.TKPulseListener;

/**
 * @Auther: bcl
 * @Description: 订单类
 * @Date: Create in 5:35 PM 2020/4/26
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay() {
        return pay(PayStrategyType.DEFAULT_PAY);
    }

    public PayState pay(PayStrategyType type) {
        Payment payment = PayStrategy.get(type);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额为：" + amount + ",开始扣款。。。");
        return payment.pay(uid, amount);
    }
}
