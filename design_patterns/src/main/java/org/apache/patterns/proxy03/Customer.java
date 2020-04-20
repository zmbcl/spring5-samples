package org.apache.patterns.proxy03;

import org.apache.patterns.proxy01.Person;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:37 下午 2020/4/20
 */
public class Customer implements Person {

    @Override
    public void findLove() {
        System.out.println("我的要求，高富帅");
    }
}
