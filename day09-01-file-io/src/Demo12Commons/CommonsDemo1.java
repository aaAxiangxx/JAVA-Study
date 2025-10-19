package Demo12Commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class CommonsDemo1 {
    public static void main(String[] args) throws Exception {
        FileUtils.copyFile(new File("day09-01-file-io\\src\\cs.txt"), new File("day09-01-file-io\\src\\csCopy.txt"));
    }
}
