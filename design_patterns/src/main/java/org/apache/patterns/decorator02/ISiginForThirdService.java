package org.apache.patterns.decorator02;

/**
 * @Auther: bcl
 * @Description: 升级部分
 * @Date: Create in 9:42 下午 2020/4/27
 */
public interface ISiginForThirdService extends ISiginService {
    // QQ登录
    ResultMsg loginForQQ(String id);

    // 电话号码登录
    ResultMsg loginForTel(String telphone);

    // 注册后自动登录
    ResultMsg loginForRegist(String username, String password);
}
