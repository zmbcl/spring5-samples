package org.apache.patterns.decorator02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:47 下午 2020/4/27
 */
public class Test_Decorator {
    public static void main(String[] args) {
        ISiginForThirdService service = new SiginForThirdService(new SiginService());
        service.loginForQQ("xljfljalfj");
        // 动态增加或覆盖原有方法时，采用装饰者模式
    }
}
