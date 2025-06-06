//学生类
    //封装
    public class Student {
        String name;
        double chinese;
        double math;

        public void printall(){
            System.out.println(name + "的总成绩为：" + (chinese + math));
        }
        public void printaverage(){
            System.out.println(name + "的平均成绩为：" + (chinese + math) / 2);
        }
    }
