package myLessons.ioFiles.traineIOFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Train {

    public static void main(String[] args) throws IOException {
        //пример: читаем из одного файла и сразу пишем в другой файл

        FileReader fileReader = new FileReader("ExampleTest.txt");
        int charact;
        String s;

        FileWriter fileWriter = new FileWriter("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\traineIOFiles\\FileTest.txt");
        while ((charact = fileReader.read())!=-1){
      //     s = String.valueOf((char)charact);
            fileWriter.write(charact);
        }

            fileWriter.close();
            fileReader.close();


    }


}
