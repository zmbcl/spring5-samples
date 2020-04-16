package org.apache.patterns.factory03;

/**
 * @Auther: bcl
 * @Description: 抽象工厂模式
 * @Date: Create in 4:16 下午 2020/4/16
 * 抽象工厂模式：指提供一个创建一系列相关或者相互依赖对象的接口，无须指定他们的具体类。
 * 缺点：
 *      规定所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口
 *      增加了系统抽象性和理解难度
 */
public class Test_AbstractFactory {
    public static void main(String[] args) {
        JavaCourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
