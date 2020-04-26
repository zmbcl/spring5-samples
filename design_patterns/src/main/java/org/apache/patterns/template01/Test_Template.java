package org.apache.patterns.template01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 8:53 下午 2020/4/26
 */
public class Test_Template {
    public static void main(String[] args) {
        System.out.println("--- java架构师课程 ---");
        NetworkCourse course1 = new JavaCourse();
        course1.createCourse();
        System.out.println("--- 大数据课程 ---");
        NetworkCourse course2 = new BigDataCourse(true);
        course2.createCourse();
    }
}
