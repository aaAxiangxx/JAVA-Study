package statictest;

public class Student {
    //静态变量：有static修饰，只加载一份，可以被类和和全部对象加载
    static String name;
    //实例变量：没有static修饰，属于对象，每个对象都有一份
    int age;
}
