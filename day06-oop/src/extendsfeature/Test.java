package extendsfeature;

public class Test {
    public static void main(String[] args) {
        //目标：继承的注意事项，继承的特点
    }
}
//1.java的类只能是单继承，不能多继承，支持多层继承
//2，一个类要么直接继承Object类，要么默认继承Object类，要么间接继承Object类
class A {

}
class B extends A{

}
class C extends B {

}