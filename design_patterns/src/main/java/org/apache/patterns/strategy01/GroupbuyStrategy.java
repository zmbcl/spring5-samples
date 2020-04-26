package org.apache.patterns.strategy01;

/**
 * @Auther: bcl
 * @Description: 拼团策略类
 * @Date: Create in 4:52 下午 2020/4/26
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
