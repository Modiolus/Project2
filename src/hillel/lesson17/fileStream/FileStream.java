package hillel.lesson17.fileStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStream {
    public static void main(String[] args) throws IOException{

        InputStream inputStream = new FileInputStream("D:\\Projects\\Project2\\src\\hillel\\lesson17\\fileStream\\input.txt");
        int size = inputStream.available(); //available (пер. "доступный") - это размер символов в файле
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print((char) inputStream.read());

        }
        inputStream.close();


    }
}
