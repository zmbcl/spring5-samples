package org.apache.patterns.template01;

/**
 * @Auther: bcl
 * @Description: 模板会有一个后者多个未实现方法，而且这几个方法有固定的执行顺序
 * @Date: Create in 8:38 下午 2020/4/26
 * 创建课程为例子：
 *      发布预习资料=》制作课件ppt=》在线直播=》提交课堂笔记=》提交源码=》布置作业=》检查作业
 */
public abstract class NetworkCourse {
    protected final void createCourse() {
        // 发布预习资料
        this.postPreResource();
        // 制作课件
        this.createPPT();
        // 在线直播
        this.liveVideo();
        // 提交课堂笔记
        this.postNote();
        // 提交源码
        this.postSource();
        // 布置作业，有些课是没有作业的，有些课是有作业的
        // 如果有作业，检查作业，如果没有作业，流程结束
        if (needHomework()) {
            checkHomework();
        }

    }

    final void postPreResource() {
        System.out.println("发布预习资料");
    }

    final void createPPT() {
        System.out.println("创建备课PPT");
    }

    final void liveVideo() {
        System.out.println("直播授课");
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void postSource() {
        System.out.println("提交源码");
    }

    // 钩子方法：实现流程的微调
    protected boolean needHomework() {
        return false;
    }

    abstract void checkHomework();
}
