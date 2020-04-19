package org.apache.patterns.singleton03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Auther: bcl
 * @Description:
 * @Date: Create in 2:24 下午 2020/4/19
 */
public class TestSingletonSeriable {
    public static void main(String[] args) {
        Test_SingletonSeriable();
    }

    public static void Test_SingletonSeriable() {
        SingletonSeriable seriable1 = null;
        SingletonSeriable seriable2 = SingletonSeriable.getInstance();

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("SingletonSeriable.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(seriable2);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream inputStream = new FileInputStream("SingletonSeriable.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            seriable1 = (SingletonSeriable) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(seriable1);
            System.out.println(seriable2);
            System.out.println(seriable1 == seriable2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
