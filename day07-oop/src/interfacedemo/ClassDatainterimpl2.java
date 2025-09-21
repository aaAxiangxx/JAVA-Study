package interfacedemo;

public class ClassDatainterimpl2 implements ClassDatainter{
    private Student[] students;
    public ClassDatainterimpl2(Student[] students){
        this.students =students;
    }
    @Override
    public void printAllStudentInfos() {
        int nan = 0;
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
            if (s.getSex() == '男'){
                nan++;
            }

        }
        System.out.println("男学生人数：" + nan);
        System.out.println("女学生人数：" + (students.length - nan));
    }

    @Override
    public void printAverageScore() {
        System.out.println("平均分如下：");
        Student s1 = students[0];
        double sum = s1.getScore();
        double max = s1.getScore();
        double min = s1.getScore();
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            sum += s.getScore();

            if(s.getScore() > max){
                max = s.getScore();
            }
            if (s.getScore() < min){
                min = s.getScore();
            }
        }
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("平均分" + (sum - max - min) / (students.length - 2));

    }
}
