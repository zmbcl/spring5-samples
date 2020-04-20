package org.apache.patterns.proxy01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:02 下午 2020/4/20
 */
public class Son implements Person {
    @Override
    public void findLove() {
        // 我没有时间工作忙
        System.out.println("儿子要求：肤白貌美大长腿。");
    }
}
