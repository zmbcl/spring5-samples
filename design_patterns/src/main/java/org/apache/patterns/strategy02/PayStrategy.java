package org.apache.patterns.strategy02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: bcl
 * @Description: 支付策略管理类
 * @Date: Create in 5:29 PM 2020/4/26
 */
public class PayStrategy {
    private static Map<PayStrategyType, Payment> payStrategy = new HashMap<>();

    static {
        payStrategy.put(PayStrategyType.DEFAULT_PAY, new AliPay());
        payStrategy.put(PayStrategyType.ALI_PAY, new AliPay());
        payStrategy.put(PayStrategyType.WETCHAT_PAY, new WetchatPay());
        payStrategy.put(PayStrategyType.UNION_PAY, new UnionPay());
    }

    public static Payment get(PayStrategyType type) {
        Payment payment = payStrategy.get(type);
        return payment == null ? payStrategy.get(PayStrategyType.DEFAULT_PAY) : payment;
    }

}

enum PayStrategyType {
    DEFAULT_PAY, ALI_PAY, WETCHAT_PAY, UNION_PAY;
}