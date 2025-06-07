package extendsoverride;

public class Test {
    public static void main(String[] args) {
        //认识方法重写，再搞清楚场景
        cat c = new cat();
        c.cry();
    }
}
class cat extends Anmial{
    //认识方法重写,方法重写；方法名称，形参列表必须一样，这个方法就是方法重写
    //私有方法，静态方法不能被重写，如果重写会报错
    //私有方法不能被继承
    //重写的规范：声明不变，重新实现！！！
    @Override//注解，告诉编译器，这个方法是重写的方法  更安全，更优雅
    public void cry(){
        System.out.println("猫叫~~~~");
    }
}
class Anmial{
    public void cry(){
        System.out.println("动物叫~~~~");
    }
}