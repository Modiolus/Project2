package myLessons.ioFiles;

import java.io.*;

public class BufferedExample {
    public static void main(String[] args) {
        // Buffered используется когда нужно работать с большими файлами и чтобы они буферизировались для ускорения работы
        // позволяет читать и писать данные
        // по сути BufferedReader и bufferedWriter это обёртки для привычных FileReader и FileWriter, которые мы пишем в параметрах
        // экземпляры которых мы прописываем в параметрах
        // здесь использовали try with resources, поэтому без close()
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\traineIOFiles\\FileTest.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(
                     new FileWriter("textBufferedEx.txt", true)))
        {

            // !!!ниже чтение и запись ПОСИМВОЛЬНО как у FileWriter\FileReader
//            int character;
//            while ((character=bufferedReader.read())!=-1){
//                bufferedWriter.write(character);
//            }
            // !!!ниже чтение и запись ПОСТРОЧНО через метод readLine()
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n"); // просто для перевода строки, т.к. записывает всё в строку

            }
           bufferedWriter.append("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
