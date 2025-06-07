package extends6constructor;

public class Test3 {
    //目标：理解this(...)调用兄弟构造器
    //创建对象，存储一个学生的数据
    public static void main(String[] args) {
        Student s1 = new Student("张三", '男', 18);
        Student s2 = new Student("李四", '女', 19,"清华大学");
        System.out.println(s1);
        System.out.println(s2);
    }
}
