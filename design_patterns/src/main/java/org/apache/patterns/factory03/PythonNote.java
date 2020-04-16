package org.apache.patterns.factory03;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:31 下午 2020/4/16
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写python笔记");
    }
}
