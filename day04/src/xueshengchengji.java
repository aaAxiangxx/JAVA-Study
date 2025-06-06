public class xueshengchengji {
    //录入学生成绩
    public static void main(String[] args) {
        input();
    }
//    录入学生成绩 定义数组，存储学生成绩
    /********************************************************
     测试git1231112  1 111
     测试git123

     1
     ctrl + alt + l 格式化代码
     ctrl + k 提交
     alt + i 确认提交
     ctrl + shift + k 推送
     alt + p 确认推送
     2
     ctrl + k 提交
     alt + p 提交并推送
     alt + p 仍然提交并推送
     alt + p 推送

     ********************************************************/

    public static void input(){
        double[] scores = {123.45, 678.90, 234.56, 789.01, 345.67, 890.12, 456.78, 901.23, 567.89, 999.99};
//        double[] scores = new double[8];
//        //录入学生成绩存入数组
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0;i < scores.length; i++){
//            System.out.println("请输入第" + (i + 1) + "个学生的成绩：");
//            scores[i] = sc.nextDouble();
//        }
        //遍历数组，统计总分，输出平均分
        double num = 0.0;
        for (int i = 0; i < scores.length; i++) {
            double score = scores[i];
            num += score;
        }
        //求出最大值
        double max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max){
                max = scores[i];
            }
        }
        //求出最大值
        double min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min){
                min = scores[i];
            }
        }
        System.out.println("平均分" + num / scores.length);
        System.out.println("最高分" + max);
        System.out.println("最低分" + min);

    }
}
