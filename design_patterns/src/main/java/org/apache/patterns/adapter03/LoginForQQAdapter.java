package org.apache.patterns.adapter03;

import org.apache.patterns.adapter02.ResultMsg;

/**
 * @Auther: bcl
 * @Description: QQ登录
 * @Date: Create in 11:31 上午 2020/4/27
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
