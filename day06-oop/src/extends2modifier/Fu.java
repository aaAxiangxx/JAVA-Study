package extends2modifier;

public class Fu {
    private void privatemethod(){
        System.out.println("private 父类方法 只能本类中访问");
    }

    void method(){
        System.out.println("空 缺省方法 只能当前类中，同一个包下的其他类中");
    }

    protected void protectedmethod(){
        System.out.println("protected 保护方法 只能当前类中，同一个包下的其他类中，子孙类中访问");
    }

    public void publicmethod(){
        System.out.println("public 公共方法 任何类中都可以访问");
    }

    public static void main(String[] args) {
        Fu fu = new Fu();
        fu.method();
        fu.privatemethod();
        fu.protectedmethod();
        fu.publicmethod();
    }
}
