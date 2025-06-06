package extends2modifier;

public class Test {
    public static void main(String[] args) {
        //目标；认识四种权限的修饰范围
        Fu fu = new Fu();
        fu.method();
        //fu.privatemethod(); 报错
        fu.protectedmethod();
        fu.publicmethod();
    }
}
