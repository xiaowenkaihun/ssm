package chapter1;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/20 10:39
 * 文件描述：
 */
@SuppressWarnings("all")
public class TestReflection {
    // 1、new一个对象，调用方法
    @Test
    public void test1(){
        Cat cat = new Cat();
        cat.hi();
        // 如果要调用cry方法，就需要修改源码
        // cat.hi()>>>cat.cry()
    }
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/chapter1/re.properties"));
        String classPath = properties.get("classPath").toString();
        String method = properties.get("method").toString();
        System.out.println("classPath="+classPath);
        System.out.println("method="+method);
    }

    // 这里就需要反射
    @Test
    public void test3() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/chapter1/re.properties"));
        String classPath = properties.get("classPath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classPath="+classPath);
        System.out.println("method="+methodName);

        // 类加载器，返回一个Class类型的对象
        Class cls = Class.forName(classPath);
        // 通过cls对象 得到你加载的chapter1.Cat的对象实例
        Object o = cls.newInstance();
        //System.out.println(o.getClass());//可以打印它的运行类型，发现其实获得的就是Cat的实例化对象
        // 那我们进行强转
        // Cat cat = (Cat) cls.newInstance();
        // 下反射的机制当中，把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        // 可以通过method1调用实现方法
        System.out.println("-------------------");
        method1.invoke(o);// 方法.invoke(Object)
    }

}
