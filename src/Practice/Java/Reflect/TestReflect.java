package Practice.Java.Reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class TestReflect {
    public static void main(String[] args) {
        // 获取构造函数
        getConstructions();
        // 获取方法
        getMethods();
        // 获取变量
        getFields();
        // 操作数组
        opArray();
    }

    /**
     * 反射获取构造函数
     */
    private static void getConstructions() {
        try {
            Class<?> aClass = Class.forName("Practice.Java.Reflect.Person");
            Constructor<?>[] constructors = aClass.getConstructors();
            print("所有public的构造函数", constructors);
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            print("所有的构造函数", declaredConstructors);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取方法
     */
    private static void getMethods() {
        try {
            Class<?> aClass = Class.forName("Practice.Java.Reflect.Person");
            Method[] methods = aClass.getMethods();
            print("所有public的函数，包括父类的方法", methods);
            Method[] declaredMethods = aClass.getDeclaredMethods();
            print("所有定义的函数", declaredMethods);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取变量
     */
    private static void getFields() {
        try {
            Class<?> aClass = Class.forName("Practice.Java.Reflect.Person");
            Field[] fields = aClass.getFields();
            print("所有public的成员变量", fields);
            Field[] declaredFields = aClass.getDeclaredFields();
            print("所有定义的成员变量", declaredFields);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作数组示例
     */
    public static void opArray() {
        String[] strArray = new String[]{"Java", "Kotlin", "Scala", "Swift", "OC", "Dart", "Shell", "Groovy"};
        // 在数组中插入数据
        Array.set(strArray, 0, "Flutter");
        Class<?> clazz = strArray.getClass();
        // 判断是否是数组
        if (clazz.isArray()) {
            int length = Array.getLength(strArray);
            System.out.println("反射操作数组");
            for (int i = 0; i < length; i++) {
                // 取数据
                Object object = Array.get(strArray, i);
                String className = object.getClass().getName();
                System.out.println("数组元素: " + object + ", className=" + className);
            }
        }
    }

    private static <T> void print(String message, T[] array) {
        System.out.println(message);
        for (T t : array) {
            System.out.println(t);
        }
    }
}
