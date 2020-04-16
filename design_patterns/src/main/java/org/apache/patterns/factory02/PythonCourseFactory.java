package org.apache.patterns.factory02;

import org.apache.patterns.factory01.CourseFactory;
import org.apache.patterns.factory01.ICourse;
import org.apache.patterns.factory01.PythonCourse;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:03 下午 2020/4/16
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
