package myLessons.ioFiles.trainCheck;

import java.io.*;

public class Check {
    public static void main(String[] args) throws IOException {
  // попытка записать картинку с ж/диска в корень проекта. Попытка - неудачна. Т.к. это бинарный файл и нужно применить
  // filOutputStream и filInputStream. Соответствующий пример находится
  // по пути--> D:\Projects\Project2\src\myLessons\ioFiles\binaryStream\CopyExFileIOStream.java

        BufferedReader reader = new BufferedReader(new FileReader("D:\\Основное Хранилище\\Красота временно\\Фото\\Полотенца\\0680-polotenca-v-rulone.jpg"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("0680-polotenca-v-rulone.jpg"));
        String s = null;

        while ((s = reader.readLine()) != null) {
            writer.write(s);

        }
        reader.close();
        writer.close();
    }
}
