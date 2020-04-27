package org.apache.patterns.adapter01;

/**
 * @Auther: bcl
 * @Description: 220V交流电
 * @Date: Create in 11:05 上午 2020/4/27
 */
public class AC220 {
    public int outputAC220() {
        int output = 220;
        System.out.println("输出交流电" + output + "V");
        return output;
    }
}
