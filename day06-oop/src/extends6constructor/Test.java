package extends6constructor;

public class Test {
    public static void main(String[] args) {
        //目标：认识子类构造器，再看应用场景
        //子类构造器必须先调用父类的构造器，再执行自己的构造器
        Zi zi = new Zi();

    }
}

class Zi extends Fu{
    public Zi(){
        //super();//默认调用父类的无参构造器，写不写都有
        //super(10);//指定调用父类的有参构造器
        System.out.println("Zi的构造器");
    }
}

class Fu {
    public Fu() {
        System.out.println("Fu的构造器");
    }
    public Fu(int num) {
        System.out.println("Fu的构造器"+num);
    }
}