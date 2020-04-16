package org.apache.patterns.factory01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:43 下午 2020/4/16
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
