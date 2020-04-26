package org.apache.patterns.strategy01;

/**
 * @Auther: bcl
 * @Description: 返现促销策略类
 * @Date: Create in 4:51 下午 2020/4/26
 */
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
