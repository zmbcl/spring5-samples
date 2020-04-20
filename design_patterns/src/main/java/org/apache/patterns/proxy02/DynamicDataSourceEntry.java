package org.apache.patterns.proxy02;

/**
 * @Auther: bcl
 * @Description: 动态切换数据源
 * @Date: Create in 3:12 下午 2020/4/20
 * 静态代理，主要完成功能：根据订单创建时间自动按年进行分库
 */
public class DynamicDataSourceEntry {
    // 默认数据源
    public final static String DEFAULT_SOURCE = null;
    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public DynamicDataSourceEntry() {
    }

    // 清空数据源
    public static void clear() {
        LOCAL.remove();
    }

    // 获取当前正在使用的数据源的名字
    public static String get() {
        return LOCAL.get();
    }

    // 还原当前切换的数据源
    public static void restore() {
        LOCAL.set(DEFAULT_SOURCE);
    }

    // 设置已知名字的数据源
    public static void set(String source) {
        LOCAL.set(source);
    }

    // 根据年份动态设置数据源
    public static void set(int year) {
        LOCAL.set("DB_" + year);
    }
}
