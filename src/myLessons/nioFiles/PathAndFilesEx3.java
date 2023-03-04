package myLessons.nioFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class PathAndFilesEx3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Запись и чтение с помощью nio
       Path filePath = Paths.get("test13.txt");
        if (!Files.exists(filePath)) { // в таком случае если уже файл есть, то не выбросится исключение
            Files.createFile(filePath);
        }
        String dialog = "-Privet\n-Privet\n-Kak dela?\n-Xorosho! Kak u tebya?"
                + "\n-Toje xorosho";

        Files.write(filePath, dialog.getBytes());// filePath - куда записывать, dialog.getBytes() - что записывать в байтах. записывает в файл


        Thread.sleep(1500);

        List<String> list = Files.readAllLines(filePath); // читаем весь текст

        for (String text : list) {
            System.out.println(text);
        }


    }
}
