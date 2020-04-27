package org.apache.patterns.decorator02;

/**
 * @Auther: bcl
 * @Description: 第三方登录自由适配
 * @Date: Create in 9:45 下午 2020/4/27
 */
public class SiginForThirdService implements  ISiginForThirdService {
    private ISiginService service;

    public SiginForThirdService(ISiginService service) {
        this.service = service;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForTel(String telphone) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        return null;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return service.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return service.login(username,password);
    }
}
