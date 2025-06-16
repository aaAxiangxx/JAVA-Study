package demo.src.day03;

public class yanzhengma {
    // 验证码生成器
    public static void main(String[] args) {
        System.out.println("验证码：" + getCode(6));
    }

    //生成验证码
    public static String getCode(int n){
        String code = "" ;
        for (int i = 0; i < n; i++) {

            int type = (int) (Math.random() * 3);
            switch (type) {
                case 0:
                    int num = (int) (Math.random() * 10);//0-9
                    code += num;
                    break;
                case 1:
                    int num1 = (int) (Math.random() * 26);//26个小写字母
                    char ch = (char) (65 + num1);//ASCII小写a = 65
                    code += ch;
                    break;
                case 2:
                    int num2 = (int) (Math.random() * 26);//26个大写字母
                    char ch1 = (char) (97 + num2);//ASCII大写A = 97
                    code += ch1;
                    break;
            }

        }
        return code;
    }

}