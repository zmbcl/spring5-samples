package org.apache.patterns.proxy02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:10 下午 2020/4/20
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }
}
