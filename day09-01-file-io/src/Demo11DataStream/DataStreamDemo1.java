package Demo11DataStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStreamDemo1 {
    public static void main(String[] args) {
        try (
                DataOutputStream dat = new DataOutputStream(new FileOutputStream("day09-01-file-io\\src\\DateStreamDemo1.txt"))
                ){
            dat.writeInt(100);
            dat.writeByte(1);
            dat.writeBoolean(true);
            dat.writeUTF("hello world");
            dat.writeDouble(100.0);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
