package StringDemo;

public class StringTest {
    public static void main(String[] args) {
        String code = getcode(4);
        System.out.println(code);

        System.out.println(getcode(10));
    }
    public static String getcode(int n){
        //定义一个变量记住所有字符
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz" ;
        //定义一个变量记住验证码的字符
        String code = "" ;
        //循环n次，每次生成一个随机字符，拼接成字符串
        for (int i = 0; i < n; i++) {
            //随机一个索引
            int index = (int)(Math.random() * str.length());//[0,1) * 50 = [0,49]
            //根据索引获取字符，拼接成字符串
            code += str.charAt(index);
        }
        return code;
    }
}
