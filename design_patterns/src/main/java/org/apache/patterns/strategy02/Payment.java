package org.apache.patterns.strategy02;

import javax.swing.*;
import java.util.function.DoubleConsumer;

/**
 * @Auther: bcl
 * @Description: 定义支付规范和支付逻辑
 * @Date: Create in 5:15 下午 2020/4/26
 */
public abstract class Payment {
    // 支付类型
    public abstract String getName();

    // 查询余额
    protected abstract double queryBalance(String uid);

    // 扣款支付
    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "支付失败","余额不足");
        }
        else {
            return new PayState(200, "支付成功","支付金额：" + amount);
        }
    }
}
