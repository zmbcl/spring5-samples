package org.apache.patterns.prototype02;

import java.io.Serializable;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 10:34 上午 2020/4/20
 */
public class JinGuBang implements Serializable {
    public float h = 100;
    public float d = 10;

    public void big() {
        this.d *= 2;
        this.h *= 2;
    }

    public void small() {
        this.d /= 2;
        this.h /= 2;
    }
}
