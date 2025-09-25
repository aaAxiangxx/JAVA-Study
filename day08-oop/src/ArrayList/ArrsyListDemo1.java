package ArrayList;

import java.util.ArrayList;

public class ArrsyListDemo1 {
    public static void main(String[] args) {
        //创建一个ArrayList对象，代表一个集合容器
        ArrayList<String> list = new ArrayList<>();
        //添加容器
        list.add("张三");
        list.add("张四");
        list.add("张五");
        list.add("张六");
        System.out.println(list);
        System.out.println("=====================================");
        //查看容器
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);

        }
        System.out.println("====================================");
        //删除数据
        System.out.println(list.remove(0));//根据索引删除
        System.out.println(list);
        System.out.println(list.remove("张五"));//根据元素删除
        System.out.println(list);
        System.out.println("====================================");
        //修改数据
        list.set(0,"李四");
        System.out.println(list);
    }
}
