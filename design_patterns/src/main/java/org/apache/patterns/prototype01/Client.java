package org.apache.patterns.prototype01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 10:16 上午 2020/4/20
 */
public class Client {
    private Prototype prototype;
    public Client(Prototype prototype){
        this.prototype = prototype;
    }
    public Prototype startClone(Prototype prototype){
        return prototype.clone();
    }
}
