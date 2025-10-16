package Demo2recursion;

public class recursionDemo1 {
    public static void main(String[] args) {
        //计算n的阶乘
        System.out.println("5的阶乘：" + f(5));
        System.out.println("15的和：" + f2(15));
    }
    public static int f(int n){
        if (n == 1){
            return 1;
        }
        return f(n - 1) * n;//递归调用
    }
    public static int f2(int n){
        if (n == 1){
            return 1;
        }
        return f2(n - 1) + n;//递归调用
    }
}
