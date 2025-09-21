package jiekou2;

public class Test {
    public static void main(String[] args) {
        //接口弥补了单继承的不足，一个类可以实现多个接口
        People p = new Student();
        Driver d = new Student();
        BoyFriend bf = new Student();

        //接口可以实现面向接口编程，更利于解耦合。
        Driver a = new Student();
//        Driver a = new Teacher();
        BoyFriend b = new Teacher();
    }
}

interface Driver{}
interface BoyFriend{}

class People{}
class Student extends People implements Driver , BoyFriend{}

class Teacher implements Driver , BoyFriend{}