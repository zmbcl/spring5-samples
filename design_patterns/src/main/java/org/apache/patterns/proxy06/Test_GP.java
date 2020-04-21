package org.apache.patterns.proxy06;

import org.apache.patterns.proxy01.Person;
import org.apache.patterns.proxy03.Customer;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 9:20 上午 2020/4/21
 */
public class Test_GP {
    public static void main(String[] args) {
        Person person = (Person) new GPMeipo().getInstance(new Customer());
        System.out.println(person.getClass());
        person.findLove();
    }
}
