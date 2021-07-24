package com.isanthree.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // 调用系统类加载器的 getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 调用扩展类加载器的 getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载 java 的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }


    /**
     * Properties：用来读取配置文件。
     */
    @Test
    public void test2() throws Exception {

        Properties pros =  new Properties();

        // 读取配置文件的方式一：
        // 此时的文件默认在当前的module下。
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);

        // 读取配置文件的方式二：使用 ClassLoader
        // *配置文件默认识别为：当前 module 的 src 下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("src-jdbc.properties");
        pros.load(is);

        user = pros.getProperty("user");
        password = pros.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);
    }
}