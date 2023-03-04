package hillel.lesson17.bytStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
//        !!! РАБОТАЕТ БЕЗ TRY !!!
        try {
//             fis = new FileInputStream("/Users/stepurkoolksandr/javaWinter2020/lessons/src/com/hillel/lesson_17/io/byteSteram/output.txt"); // -> from
//             fos = new FileOutputStream("/Users/stepurkoolksandr/javaWinter2020/lessons/src/com/hillel/lesson_17/io/byteSteram/input.txt"); // -> to
            fis = new FileInputStream("D:\\Projects\\Project2\\src\\hillel\\lesson17\\bytStream\\input.txt"); // -> from
            fos = new FileOutputStream("D:\\Projects\\Project2\\src\\hillel\\lesson17\\bytStream\\output.txt"); // -> to
            int a;
            while ((a = fis.read()) != -1) {
                fos.write(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }
    }
}
