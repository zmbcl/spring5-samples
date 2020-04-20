package org.apache.patterns.proxy04;

import org.apache.patterns.proxy02.IOrderService;
import org.apache.patterns.proxy02.Order;
import org.apache.patterns.proxy02.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:48 下午 2020/4/20
 */
public class Test_Proxy {
    public static void main(String[] args) throws ParseException {
        Order order = new Order();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse("2020/06/24");
        order.setCreateTime(date.getTime());

        IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
        orderService.createOrder(order);
    }
}
