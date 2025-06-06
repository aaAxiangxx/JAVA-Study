package student;

public class student {
    //1.私有成员变量
    private String name;
    private double chiness;
    private double math;

    //无参数构造器

    public student() {
    }

    //有参数构造器
    public student(String name, double chiness, double math) {
        this.name = name;
        this.chiness = chiness;
        this.math = math;
    }

    //2.提供公开的getter和setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChiness() {
        return chiness;
    }

    public void setChiness(double chiness) {
        this.chiness = chiness;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }
}
