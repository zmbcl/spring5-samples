package org.apache.patterns.proxy07;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 2:57 下午 2020/4/21
 */
public class Test_Cglib {
    public static void main(String[] args) throws Exception {
        // 利用CGLib的代理类可以将内存中的.class文件写入本地磁盘
        // 会发现根目录下多了三个.class文件，Customer$$EnhancerByCGLIB$$48dfeb3.class就是生成的代理类，集成了Customer类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "cglib_proxy_class");

        Customer obj = (Customer) new CGLibMeipo().getInstance(Customer.class);
        obj.findLove();
    }


}
