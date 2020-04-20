package org.apache.patterns.proxy02;

/**
 * @Auther: bcl
 * @Description: 持久层操作
 * @Date: Create in 3:08 下午 2020/4/20
 */
public class OrderDao {
    public int insert(Order order) {
        System.out.println("orderDao创建order成功");
        return 1;
    }
}
