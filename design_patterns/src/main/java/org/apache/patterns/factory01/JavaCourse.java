package org.apache.patterns.factory01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:41 下午 2020/4/16
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
