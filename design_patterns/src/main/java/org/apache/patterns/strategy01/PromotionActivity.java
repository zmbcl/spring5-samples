package org.apache.patterns.strategy01;

/**
 * @Auther: bcl
 * @Description: 促销活动方案类
 * @Date: Create in 4:55 下午 2020/4/26
 */
public class PromotionActivity {
    private PromotionStrategy strategy;

    public PromotionActivity(PromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doPromotion();
    }
}
