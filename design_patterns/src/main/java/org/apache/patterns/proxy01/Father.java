package org.apache.patterns.proxy01;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 3:03 下午 2020/4/20
 */
public class Father {
    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void findLove() {
        System.out.println("父亲物色对象");
        son.findLove();
        System.out.println("双方同意交往，确定关系");
    }

}
