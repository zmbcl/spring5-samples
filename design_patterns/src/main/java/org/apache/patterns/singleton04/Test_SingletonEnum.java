package org.apache.patterns.singleton04;

import org.apache.patterns.singleton03.SingletonSeriable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 8:51 上午 2020/4/20
 */
public class Test_SingletonEnum {
    public static void main(String[] args) {
        test_enum();
    }

    public static void test_enum() {
        SingletonEnum singletonEnum1 = null;
        SingletonEnum singletonEnum2 = SingletonEnum.getInstance();
        singletonEnum2.setData(new Object());

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("SingletonEnum.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(singletonEnum2);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream inputStream = new FileInputStream("SingletonEnum.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            singletonEnum1 = (SingletonEnum) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(singletonEnum1);
            System.out.println(singletonEnum2);
            System.out.println(singletonEnum1 == singletonEnum2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
