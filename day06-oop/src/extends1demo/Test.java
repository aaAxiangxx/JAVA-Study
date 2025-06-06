package extends1demo;

public class Test {
    public static void main(String[] args) {
        //目标；认识继承，好处
        //1.创建对象，封装老师数据
        //子类可以继承父类的非私有成员
        //子类对象其实是由父类和子类多张设计图共同创建出来的，所以子类对象是完整的
        Teacher t = new Teacher();
        t.setName("张三");
        t.setSkill("java");
        t.setSex('男');
        System.out.println(t.getName());
        System.out.println(t.getSkill());
        System.out.println(t.getSex());
        System.out.println("====================");

        Consultant c = new Consultant();
        c.setName("李四");
        c.setNumber("123456");
        c.setSex('女');
        System.out.println(c.getName());
        System.out.println(c.getNumber());
        System.out.println(c.getSex());
    }
}
