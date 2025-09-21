package jiekou1;

public class Test {
    public static void main(String[] args) {
        System.out.println(B.SC_NAME);

        D d = new D();
        d.go();
        System.out.println(d.run());
        d.play();
    }
}
class D implements B , C{

    @Override
    public void go() {
        System.out.println("Go");
    }

    @Override
    public String run() {
        return "1212121";
    }

    @Override
    public void play() {
        System.out.println("Play");
    }
}
