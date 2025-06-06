package student;

public class studentoperator {
    //必须拿到要处理的学生对象
    private student s;
    public studentoperator(student s){
        this.s = s;
    }
    //提供方法，打印学生总成绩
    public void printTotal(){
        System.out.println("学生总成绩为：" + (s.getChiness() + s.getMath()));
    }

    //提供方法，打印学生平均成绩
    public void printaverage(){
        System.out.println("学生平均成绩为：" + (s.getChiness() + s.getMath())/2);
    }
}
