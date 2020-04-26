package org.apache.patterns.strategy02;

/**
 * @Auther: bcl
 * @Description: 支付状态的包装类PayState
 * @Date: Create in 5:28 PM 2020/4/26
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
