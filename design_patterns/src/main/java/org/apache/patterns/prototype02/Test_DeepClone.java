package org.apache.patterns.prototype02;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 10:44 上午 2020/4/20
 */
public class Test_DeepClone {
    public static void main(String[] args) {
        // 深克隆
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println("深克隆：" + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 浅克隆
        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng n = q.shallowClone(q);
        System.out.println("浅克隆：" + (q.jinGuBang == n.jinGuBang));
    }
}
