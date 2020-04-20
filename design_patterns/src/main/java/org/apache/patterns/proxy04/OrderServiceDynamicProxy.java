package org.apache.patterns.proxy04;

import org.apache.patterns.proxy02.DynamicDataSourceEntry;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:41 下午 2020/4/20
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy");
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void before(Object target) {
        try {
            System.out.println("proxy before method");
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(format.format(new Date(time)));
            System.out.println("静态代理类自动非配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntry.set(dbRouter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void after() {
        System.out.println("proxy after method");
    }
}
