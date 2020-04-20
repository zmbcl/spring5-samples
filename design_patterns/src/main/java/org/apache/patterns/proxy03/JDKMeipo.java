package org.apache.patterns.proxy03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: bcl
 * @Description: 创建媒婆（婚介所）
 * @Date: Create in 3:32 下午 2020/4/20
 */
public class JDKMeipo implements InvocationHandler {
    // 被代理的对象，把引用保存下来
    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before(){
        System.out.println("我是媒婆：我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }
    private void after(){
        System.out.println("如果合适的化，就准备办事");
    }
}
