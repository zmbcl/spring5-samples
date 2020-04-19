package org.apache.patterns.singleton03;

import java.io.Serializable;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 2:20 下午 2020/4/19
 */
public class SingletonSeriable implements Serializable {
    // 序列化就是把内存中的状态通过转换成字节码的形式从而转换一个I/O流，写入其他地方（可以是磁盘、网络I/O）
    // 内存中的状态会永久保存下来

    // 反序列化就是将已经持久化的字节码内容转换成I/O流，通过I/O流的读取，进而将读取的内容转换为Java对象
    // 在转换的过程中会重新创建对象new

    public final static SingletonSeriable SINGLETON_SERIABLE = new SingletonSeriable();
    private SingletonSeriable(){
    }
    public static SingletonSeriable getInstance(){
        return SINGLETON_SERIABLE;
    }
}
