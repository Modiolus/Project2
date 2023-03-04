package myLessons.ioFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader reader = null;

        try {
            reader = new FileReader("ExampleTest.txt"); // можно указывать как путь так и файл

            int character; // !!! интовая переменная

            while ((character = reader.read()) != -1) {
                // reader.read() возвращает int() и читает файл посимвольно!! Как текст закончится, то вернёт -1
                System.out.print((char) character);// приводим int к char
            }
            //System.out.println();
            System.out.println("\nDone!");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally
//        {
//            reader.close();
//
//       }
       

    }

}
