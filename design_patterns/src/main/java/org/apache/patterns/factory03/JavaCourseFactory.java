package org.apache.patterns.factory03;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:30 下午 2020/4/16
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
