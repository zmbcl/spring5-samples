package org.apache.patterns.proxy06;

import java.lang.reflect.Method;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:05 上午 2020/4/21
 */
public class GPMeipo implements GPInvocationHandler {
    // 被代理对象，把引用保存下来
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("我是媒婆：我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("如果合适的化，就准备办事");
    }
}
