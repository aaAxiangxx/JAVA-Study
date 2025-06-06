public class Test {
    public static void main(String[] args) {
        //创建学生对象存储学生数据，并操作学生数据
        Student s1 = new Student();
        s1.name = "张三";
        s1.chinese = 100;
        s1.math = 90;
        s1.printall();
        s1.printaverage();

        Student s2 = new Student();
        s2.name = "李四";
        s2.chinese = 98;
        s2.math = 90;
        s2.printall();
        s2.printaverage();

    }
}
