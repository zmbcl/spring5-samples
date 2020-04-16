package org.apache.patterns.factory01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:44 下午 2020/4/16
 */
public class CourseFactory {
    /*public ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCourse();
        } else {
            return null;
        }
    }*/
    // 如果我们的业务继续拓展，要增加前端课程，
    // 那么工厂中的create方法就要每次都根据产品的增加修改代码逻辑，不符合开闭原则，
    // 因此继续优化如下
    public ICourse create(String className) {
        try {
            return (ICourse) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
