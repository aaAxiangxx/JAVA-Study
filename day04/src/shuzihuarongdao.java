public class shuzihuarongdao {
    //数字华容道
    public static void main(String[] args) {
        start(5);
    }
    public static void start(int n) {
        //1.定义数组
        int[][] arr = new int[n][n];
        //2.填充数据
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = count++;
            }
        }
        printArray(arr);
        System.out.println("===========打乱后的数组==========");
        //3.打乱数组中的数据
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //获取随机行索引
                //获取随机列索引
                int e = (int) (Math.random() * arr.length);
                int r = (int) (Math.random() * arr.length);
                //定义临时变量
                int temp = arr[e][r];
                //交换位置
                arr[e][r] = arr[i][j];
                //将临时变量的值赋值给当前位置
                arr[i][j] = temp;

            }
        }
        //打印数组
        printArray(arr);
    }
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
