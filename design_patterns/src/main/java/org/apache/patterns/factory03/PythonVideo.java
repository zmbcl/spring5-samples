package org.apache.patterns.factory03;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 4:30 下午 2020/4/16
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
