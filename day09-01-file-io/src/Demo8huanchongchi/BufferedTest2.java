package Demo8huanchongchi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BufferedTest2 {
    public static void main(String[] args) {
        //创建一个字符输入缓冲流
        try (
                BufferedReader dr = new BufferedReader(new FileReader("day09-01-file-io\\src\\cs.txt"));
                BufferedWriter br = new BufferedWriter(new FileWriter("day09-01-file-io\\src\\csReader.txt"));

        ) {
            List<String> data = new ArrayList<>();

            String line;
            while ((line = dr.readLine()) != null){
                data.add(line);
            }

            Collections.sort(data);
//            System.out.println(data);

            for (String s : data){
                br.write(s);
                br.newLine();
            }

            System.out.println("处理完毕！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
