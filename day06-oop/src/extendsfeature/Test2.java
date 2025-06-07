package extendsfeature;

public class Test2 {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.show();
    }
}

class Fu{
    String name = "Fu的name";
    public void run(){
        System.out.println("Fu的run的方法");
    }
}
class Zi extends Fu{
    String name = "Zi的name";
    public void show(){
        String name = "show的name";
        System.out.println(name);//show的name
        System.out.println(this.name);//Zi的name
        System.out.println(super.name);//Fu的name

        run();//子类的
        super.run();//父类的
    }
    public void run(){
        System.out.println("Zi的run的方法");
    }
}