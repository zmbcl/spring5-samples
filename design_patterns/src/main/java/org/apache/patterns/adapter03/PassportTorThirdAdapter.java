package org.apache.patterns.adapter03;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.patterns.adapter02.ResultMsg;
import org.apache.patterns.adapter02.SiginService;

/**
 * @Auther: bcl
 * @Description: 第三方登录自由适配器
 * @Date: Create in 11:35 上午 2020/4/27
 */
public class PassportTorThirdAdapter extends SiginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForTel(String phoneNum) {
        return processLogin(phoneNum, LoginForTelAdapter.class);
    }

    // 这里用到了简单工厂模式及策略模式
    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(key, adapter);
            }
            else {
                return null;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username, null);
        return super.login(username, null);
    }
}
