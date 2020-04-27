package org.apache.patterns.decorator02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:41 下午 2020/4/27
 */
public class SiginService implements ISiginService {
    @Override
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
