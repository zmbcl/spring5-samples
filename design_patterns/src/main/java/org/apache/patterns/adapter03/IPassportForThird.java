package org.apache.patterns.adapter03;

import org.apache.patterns.adapter02.ResultMsg;

/**
 * @Auther: bcl
 * @Description: 第三方登录兼容接口
 * @Date: Create in 11:33 上午 2020/4/27
 */
public interface IPassportForThird {
    ResultMsg loginForQQ(String id);

    ResultMsg loginForTel(String phoneNum);
}
