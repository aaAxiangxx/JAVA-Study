package student;

public class test {
    public static void main(String[] args) {
        student s1 = new student("张三", 96, 79);

        //创建一个学生的操作对象专门负责对学生对象的数据进行业务处理
        studentoperator operator = new studentoperator(s1);
        operator.printTotal();
        operator.printaverage();
    }
}
