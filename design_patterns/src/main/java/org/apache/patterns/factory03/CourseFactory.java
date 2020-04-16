package org.apache.patterns.factory03;

/**
 * @Auther: bcl
 * @Description: 抽象工厂是用户的主入口，是Spring中应用最广泛的一种设计模式，易于拓展
 * @Date: Create in 4:25 下午 2020/4/16
 */
public interface CourseFactory {
    INote createNote();

    IVideo createVideo();
}
