package JDK8zhihoujiekou;

public interface A {
//1.默认方法（普通实例方法），必须加default修饰符。
//默认会加public abstract修饰，可以省略不写。
//如何调用？通过实现类的对象来调用。
    default void go(){
        System.out.println("======go=====");
        run();
    }
    //2.私有方法，使用private修饰，jdk9才支持的。
    //私有的实例方法
    //如何调用？使用接口中的其他实例方法调用。
    private void run(){
        System.out.println("======run=====");
    }
    //3.静态方法，使用static修饰，jdk8才支持的。
    //默认会加public
    //如何调用？只能使用当前接口名来调用。
    static void eat(){
        System.out.println("======eat=====");
    }
}
