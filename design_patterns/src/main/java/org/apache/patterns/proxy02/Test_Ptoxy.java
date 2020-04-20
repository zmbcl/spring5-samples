package org.apache.patterns.proxy02;

import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:25 下午 2020/4/20
 */
public class Test_Ptoxy {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date date = format.parse("2017/02/02");
            order.setCreateTime(date.getTime());

            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
