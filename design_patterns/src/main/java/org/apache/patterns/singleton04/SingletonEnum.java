package org.apache.patterns.singleton04;

/**
 * @Auther: bcl
 * @Description: 注册式单例：枚举式
 * @Date: Create in 8:48 上午 2020/4/20
 */
public enum SingletonEnum {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}
