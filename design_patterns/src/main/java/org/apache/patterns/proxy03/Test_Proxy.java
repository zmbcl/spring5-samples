package org.apache.patterns.proxy03;

import org.apache.patterns.proxy01.Person;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:38 下午 2020/4/20
 */
public class Test_Proxy {
    public static void main(String[] args) {
        Person person = (Person) new JDKMeipo().getInstance(new Customer());
        person.findLove();
    }
}
