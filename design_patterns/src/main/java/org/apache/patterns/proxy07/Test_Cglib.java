package org.apache.patterns.proxy07;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 2:57 下午 2020/4/21
 */
public class Test_Cglib {
    public static void main(String[] args) throws Exception {
        Customer obj = (Customer) new CGLibMeipo().getInstance(Customer.class);
        obj.findLove();
    }
}
