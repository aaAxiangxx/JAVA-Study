public class erweishuzu {
    //二维数组
    public static void main(String[] args) {
        test();
        test1();
    }
    public static void test() {
        //静态初始化二维数组
        String[][] arr = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8"}
        };

        //访问：数组名[行索引]
        String[] names = arr[2];
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        //访问：数组名[行索引][列索引]
        System.out.println(arr[1][2]);

        //长度访问，数组名.length
        System.out.println(arr.length);
        System.out.println(arr[2].length);


        //动态初始化二维数组
        int[][] arr1 = new int[3][5];
    }
    //遍历输出二维数组
    public static void test1() {
        String[][] arr = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8"}
        };
        //1
        for (int i = 0; i < arr.length; i++) {
            String[] names = arr[i];
            for (int j = 0; j < names.length; j++) {
                System.out.print(names[j] + "\t");
            }
        System.out.println();
        }
        //2
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
