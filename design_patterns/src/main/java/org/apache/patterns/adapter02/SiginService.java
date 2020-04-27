package org.apache.patterns.adapter02;

/**
 * @Auther: bcl
 * @Description: 老系统登录代码
 * @Date: Create in 11:14 上午 2020/4/27
 */
public class SiginService {
    public ResultMsg regist(String name, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    public ResultMsg login(String name, String password) {
        return null;
    }
}
