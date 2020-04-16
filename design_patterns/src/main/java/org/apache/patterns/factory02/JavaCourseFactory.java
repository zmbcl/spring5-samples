package org.apache.patterns.factory02;

import org.apache.patterns.factory01.ICourse;
import org.apache.patterns.factory01.JavaCourse;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:02 下午 2020/4/16
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
