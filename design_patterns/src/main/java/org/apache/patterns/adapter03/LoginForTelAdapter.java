package org.apache.patterns.adapter03;

import org.apache.patterns.adapter02.ResultMsg;

/**
 * @Auther: bcl
 * @Description: 手机号登录
 * @Date: Create in 11:32 上午 2020/4/27
 */
public class LoginForTelAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof  LoginForTelAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
