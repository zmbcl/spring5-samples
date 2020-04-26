package org.apache.patterns.strategy01;

/**
 * @Auther: bcl
 * @Description: 无优惠策略
 * @Date: Create in 4:54 下午 2020/4/26
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
