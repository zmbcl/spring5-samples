package org.apache.patterns.adapter03;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:44 上午 2020/4/27
 */
public class Test_AdapterLogin {
    public static void main(String[] args) {
        IPassportForThird third = new PassportTorThirdAdapter();
        third.loginForQQ("11111");
    }
}
