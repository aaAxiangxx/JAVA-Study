package statictest;

//     ctrl + k 提交
//     alt + p 提交并推送
//     alt + p 仍然提交并推送
//     alt + p 推送

//实例==对象
public class Test {
    public static void main(String[] args) {
        //目标：认识static修饰成员变量，特点，访问机制，搞清楚作用
        //1.类名。静态变量（推荐）
        Student.name = "袁华";
        System.out.println(Student.name);

        //2.对象名，静态变量（不推荐）
        Student s1 = new Student();
        s1.name = "马冬梅";

        Student s2 = new Student();
        s2.name = "秋雅";

        System.out.println(s1.name);
        System.out.println(Student.name);

        //对象名.实例变量
        s1.age = 222;
        s2.age = 333;
        System.out.println(s1.age);
        System.out.println(s2.age);
    }
}
