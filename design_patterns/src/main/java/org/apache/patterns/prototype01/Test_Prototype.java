package org.apache.patterns.prototype01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: bcl
 * @Description: 浅克隆
 * @Date: Create in 10:18 上午 2020/4/20
 * 测试结果来看，hobbies引用地址是相同的，意味着复制的不是值，而是引用的地址
 * 这样的话，如果我们修改一个对象的属性值，两个变量的引用都被修改
 * 浅引用只是完整复制了值类型数据，没有赋值引用对象
 */
public class Test_Prototype {
    public static void main(String[] args) {
        // 创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        // 填充属性，方便测试
        concretePrototype.setAge(18);
        concretePrototype.setName("prototype");
        List hobbies = new ArrayList<String>();
        concretePrototype.setHobbies(hobbies);
        System.out.println(concretePrototype);

        // 创建client对象，准备开始克隆
        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone(concretePrototype);
        System.out.println(concretePrototypeClone);
        System.out.println("克隆对象中引用类型地址值：" + concretePrototypeClone.getHobbies());
        System.out.println("原对象中引用类型地址值：" + concretePrototype.getHobbies());
        System.out.println("对象地址比较：" + (concretePrototype.getHobbies() == concretePrototypeClone.getHobbies()));
    }
}
