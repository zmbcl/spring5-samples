package org.apache.patterns.factory02;

import org.apache.patterns.factory01.ICourse;

/**
 * @Auther: bcl
 * @Description: 工厂方法
 * @Date: Create in 4:04 下午 2020/4/16
 * 工厂方法模式指定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法模式让类的实例化推迟到子类中进行。
 * 在工厂方法中用户只需要关心所需产品对应的工厂，无需关系创建细节，而且加入新产品时符合开闭原则。
 * 使用场景：
 *      创建对象需要大量重复的代码
 *      客户端（应用层）不依赖于产品类实例如何被创建、如何被实现等细节
 *      一个类通过其子类来指定创建哪个对象
 * 缺点：
 *      类的个数容易过多，增加复杂度
 *      增加类系统的抽象性和理解难度
 */
public class Test_FactoryMethod {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory =  new PythonCourseFactory();
        course = factory.create();
        course.record();
    }
}
