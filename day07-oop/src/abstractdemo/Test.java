package abstractdemo;

public class Test {
    public static void main(String[] args) {
        //模板demo
        People p = new Student();//  <==== 编译看左边，运行看右边，更改右侧类名，运行结果会改变
        p.zuowen();

//        People p1 = new Student();
//        p.zuowen();
    }
}
