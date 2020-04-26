package org.apache.patterns.strategy01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:57 下午 2020/4/26
 */
public class Test_Strategy {
    public static void main(String[] args) {
//        PromotionActivity ac1 = new PromotionActivity(new CouponStrategy());
//        PromotionActivity ac2 = new PromotionActivity(new GroupbuyStrategy());
//        ac1.execute();
//        ac2.execute();
        // 优化之后的操作
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(StrategyType.COUPON));
        activity.execute();
    }
}
