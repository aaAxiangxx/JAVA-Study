package Demo11DataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataStreamDemo2 {
    public static void main(String[] args) {
        try (
                DataInputStream dat = new DataInputStream(new FileInputStream("day09-01-file-io\\src\\DateStreamDemo1.txt"))
        ){
            System.out.println(dat.readInt());
            System.out.println(dat.readByte());
            System.out.println(dat.readBoolean());
            System.out.println(dat.readUTF());
            System.out.println(dat.readDouble());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
