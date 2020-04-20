package org.apache.patterns.prototype03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 11:05 上午 2020/4/20
 * 如果我们克隆的目标对象是单例对象，那么意味着深克隆会破坏单例模式，实际上防止克隆破坏单例模式的解决思路非常简单，禁止深克隆即可
 *     单例类不实现Cloneable接口
 *     重写clone方法，在clone方法中返回单例对象即可
 */
public class Test_SingletonPrototype {
    public static void main(String[] args) {
        try {
            SingletonHungry instance = SingletonHungry.getInstance();
            List list = new ArrayList();
            instance.setList(list);
            SingletonHungry clone = instance.clone();
            System.out.println(instance == clone);
            System.out.println(clone.getList() == instance.getList());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
