package org.apache.patterns.adapter01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:10 上午 2020/4/27
 */
public class Test_AdapterPower {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5();
    }
}
