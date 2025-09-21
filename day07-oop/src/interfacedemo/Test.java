package interfacedemo;

public class Test {
    public static void main(String[] args) {
        //接口案例
        Student[] allStudents = new Student[10];
        allStudents[0] = new Student("张三", '男', 100);
        allStudents[1] = new Student("李四", '女', 10);
        allStudents[2] = new Student("王五", '男', 90);
        allStudents[3] = new Student("赵六", '女', 60);
        allStudents[4] = new Student("田七", '男', 70);
        allStudents[5] = new Student("周八", '女', 56);
        allStudents[6] = new Student("吴九", '男', 45);
        allStudents[7] = new Student("郑十", '女', 34);
        allStudents[8] = new Student("冯十一", '男', 56);
        allStudents[9] = new Student("陈十二", '女', 65);

        //定义一个接口（规范思想）
        ClassDatainter cdi = new ClassDatainterimpl2(allStudents);
        cdi.printAllStudentInfos();
        cdi.printAverageScore();
    }
}
