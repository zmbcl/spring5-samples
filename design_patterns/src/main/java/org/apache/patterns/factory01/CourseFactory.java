package org.apache.patterns.factory01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:44 下午 2020/4/16
 */
public class CourseFactory {
    public ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCourse();
        } else {
            return null;
        }
    }
}
