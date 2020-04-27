package org.apache.patterns.adapter02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:23 上午 2020/4/27
 */
public class Test_AdapterLogin {
    public static void main(String[] args) {
        SiginForThirdService service = new SiginForThirdService();
        // 不改变原来的代码，也能够兼容新的需求，还可以再加一层策略模式
        service.loginForQQ("1");
    }
}
