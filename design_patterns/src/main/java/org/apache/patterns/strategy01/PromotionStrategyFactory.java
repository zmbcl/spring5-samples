package org.apache.patterns.strategy01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 5:01 下午 2020/4/26
 */
public class PromotionStrategyFactory {
    private static Map<StrategyType, PromotionStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(StrategyType.COUPON, new CouponStrategy());
        strategyMap.put(StrategyType.CASBACK, new CashbackStrategy());
        strategyMap.put(StrategyType.GROUPBUY, new GroupbuyStrategy());
    }

    private static final PromotionStrategy DEFAULT_STRATEGY = new EmptyStrategy();

    public static PromotionStrategy getPromotionStrategy(StrategyType type) {
        PromotionStrategy strategy = strategyMap.get(type);
        return strategy == null ? DEFAULT_STRATEGY : strategy;
    }
}

enum StrategyType {
    COUPON, CASBACK, GROUPBUY, EMPTY
}
