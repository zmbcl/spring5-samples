package org.apache.patterns.decorator02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:40 下午 2020/4/27
 */
public interface ISiginService {
    ResultMsg regist(String username, String password);

    // 登录方法
    ResultMsg login(String username, String password);
}
