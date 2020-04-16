package org.apache.patterns.factory03;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:26 下午 2020/4/16
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写Java笔记");
    }
}
