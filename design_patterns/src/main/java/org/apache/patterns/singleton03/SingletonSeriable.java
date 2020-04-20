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
    // 保证在序列化的情况下也能够实现单例模式
    // 重写readResolve方法虽然保证了返回对象的唯一性，
    // 但是通过查看ObjectInputStream的readObject()源码，实际上实例化了两次，只不过新创建的对象没有被返回而已
    // 如果创建对象的动作频率加快，内存分配开销也会随之增大，注册式单例能解决吗？
    private Object readResolve() {
        return SINGLETON_SERIABLE;
    }
}
