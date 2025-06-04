package Unknown;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainFileCopy {
    public static void main(String[] args) {
        copyUpper("Pushkin.txt");
    }

    public static void copyUpper(String fileName) {
        try(InputStream fis = new FileInputStream(fileName);
            OutputStream fos = new FileOutputStream("PushkinUpper.txt")) {

            byte[] buffer = new byte[1024];
            int r;
            String string;
            while ((r = fis.read(buffer)) > -1) {
                string = new String(buffer, 0, r).toUpperCase();
                fos.write(string.getBytes(StandardCharsets.UTF_8));
                System.out.println(string);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
