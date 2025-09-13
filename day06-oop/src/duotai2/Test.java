package duotai2;

public class Test {
    public static void main(String[] args) {
        dongwu d = new tuzi();
        dongwu d1 = new wugui();
        d.run();
        d1.run();
        //编译看左边，运行看右边
        //多态好处1：右边对象是解耦合的
//        d.eatc();//多态下的一个问题：报错，多态下不能调用子类独有功能

//        dongwu t = new tuzi();
//        go(t);

        tuzi t = new tuzi();
        go(t);

        wugui w = new wugui();
        go(w);
    }
    //宠物游戏，所有动物都可以送给这个方法开始跑步
    //多态好处2：父类类型作为参数，可以接受一切子类对象
    public static void go(dongwu a){
        System.out.println("开始。。。。");
        a.run();
    }
}
