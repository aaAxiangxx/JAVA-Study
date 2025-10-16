package Demo1Fileio;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) throws Exception {
        //创建对象代表不存在的文件路径
        File f1 = new File("E:\\桌面\\code\\java\\java-study\\11\\1.txt");
        System.out.println(f1.exists());
        System.out.println(f1.createNewFile());

        //创建对象代表不存在的文件夹路径
        File f2 = new File("E:\\桌面\\code\\java\\java-study\\11\\a");
        System.out.println(f2.mkdir());//mkdir只能创建一级文件夹

        File f3 = new File("E:\\桌面\\code\\java\\java-study\\11\\a\\b\\c");
        System.out.println(f3.mkdirs());//mkdirs可以创建多级文件夹

        System.out.println("-----------------------------------------");

        //可以获取某个目录下的全部一级文件名称
        File f4 = new File("E:\\桌面\\code\\java\\java-study");
        String[] names = f4.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-----------------------------------------");
        //可以获取某个目录下的全部一级文件对象
        File[] files = f4.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsoluteFile());//获取绝对路径
        }
    }
}
