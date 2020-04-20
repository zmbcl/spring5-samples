package org.apache.patterns.proxy05;

import org.apache.patterns.proxy01.Person;
import org.apache.patterns.proxy03.Customer;
import org.apache.patterns.proxy03.JDKMeipo;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: bcl
 * @Description: 查看jdk实现动态代理原理
 * @Date: Create in 3:59 下午 2020/4/20
 */
public class Test_01 {
    public static void main(String[] args) throws IOException {
        Person obj = (Person) new JDKMeipo().getInstance(new Customer());
        obj.findLove();

        // 通过反编译工具可以查看源代码
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        File file = new File("$Proxy0.class");
        System.out.println(file.getAbsolutePath());
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bytes);
        outputStream.close();
    }
}
