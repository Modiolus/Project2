package hillel.lesson17.writeToExistFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Example {
    /*Пример, в котором показано, как дозаписать данные в существующий файл с предварительно записанными данными*/
    public void whenWriteStringUsingBufferedWritter_thenCorrect()
            throws IOException {
        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Projects\\Project2\\src\\hillel\\lesson17\\writeToExistFile\\TestFile.txt"));
        writer.write(str);

        writer.close();
    }
    public void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo()
            throws IOException {
        String str = "World";
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Projects\\Project2\\src\\hillel\\lesson17\\writeToExistFile\\TestFile.txt", true));
        writer.append("\n");
        writer.append(str);
        //writer.write("\n"+str); // делает тоже самое

        writer.close();
    }
    public static void main(String[] args) throws IOException {
        Example example = new Example();
        example.whenWriteStringUsingBufferedWritter_thenCorrect();
       example.whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo();


    }
}
