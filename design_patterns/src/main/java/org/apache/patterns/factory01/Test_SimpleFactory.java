package org.apache.patterns.factory01;

/**
 * @Auther: bcl
 * @Description: 设计模式——简单工厂
 * @Date: Create in 3:42 下午 2020/4/16
 */
public class Test_SimpleFactory {
    public static void main(String[] args) {
        /*CourseFactory factory = new CourseFactory();
        ICourse iCourse = factory.create("java");
        iCourse.record();*/
        // 优化之后符合开闭原则的调用
        CourseFactory factory = new CourseFactory();
        ICourse iCourse = factory.create("org.apache.patterns.factory01.PythonCourse");
        iCourse.record();
    }
}
