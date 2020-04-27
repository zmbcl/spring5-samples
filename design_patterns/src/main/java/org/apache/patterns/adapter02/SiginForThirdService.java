package org.apache.patterns.adapter02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:19 上午 2020/4/27
 */
public class SiginForThirdService extends SiginService {
    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }

    public ResultMsg loginForRegist(String username, String password) {
        super.regist(username, password);
        return super.login(username, null);
    }
}
