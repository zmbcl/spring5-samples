package org.apache.patterns.proxy06;

import java.lang.reflect.Method;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 5:23 下午 2020/4/20
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
