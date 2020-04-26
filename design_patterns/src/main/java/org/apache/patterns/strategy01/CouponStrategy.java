package org.apache.patterns.strategy01;

/**
 * @Auther: bcl
 * @Description: 优惠券抵扣策略
 * @Date: Create in 4:50 下午 2020/4/26
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠卷，课程的价格直接减优惠卷面值抵扣");
    }
}
