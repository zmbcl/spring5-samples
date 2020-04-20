package org.apache.patterns.proxy02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: bcl
 * @Description: 数据源的代理类
 * @Date: Create in 3:20 下午 2020/4/20
 */
public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy");
    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRounter = Integer.valueOf(format.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRounter + "】数据源处理数据");
        DynamicDataSourceEntry.set(dbRounter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("proxy before method");
    }

    private void after() {
        System.out.println("proxy after method");
    }
}
