package JDK8zhihoujiekou;

public class Test {
    public static void main(String[] args) {
    //搞清楚接口新增的三种方法，并理解好处
        B b = new B();
        b.go();
        A.eat();
    }
}
class B implements A{

}