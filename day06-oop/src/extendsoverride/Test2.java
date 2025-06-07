package extendsoverride;

public class Test2 {
    public static void main(String[] args) {
       //目标：方法重写常见的应用场景，子类重写Objest的toString方法，以便返回对象的内容
        Student s = new Student("张三",18,'男');
        //System.out.println(s.toString());//extendsoverride.Student@2f4d3709 所谓的地址
        System.out.println(s);//extendsoverride.Student@2f4d3709 所谓的地址
        //注意1.直接输出对象，默认会调用Objest的toString方法（可以省略不写调用toString的代码），返回对象的地址信息
        //注意2.输出对象的地址实际上是没有什么意义的，开发中更希望输出对象时输出对象的内容信息，所以子类需要重写Objest的toString方法，返回对象的内容
        //    以便以后输出对象时默认就近调用子类重写的toString方法返回对象的内容

    }
}
class Student extends Object{
    private String name;
    private int age;
    private char sex;
//重写Objest的toString方法，可以右键生成代码
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

//无参构造器
    public Student() {
    }
//有参构造器
    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
//getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}