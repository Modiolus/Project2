package myLessons.nioFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        File f = new File("test155.txt");

       // f.createNewFile(); // создали файл в корне
        // Files.createFile(Paths.get("TextTest.txt")); // если файл уже существует, то выбросится исключение
        // ещё вариант создания файла через Files
        Path filePath = Paths.get("test15.txt"); // получили путь созданного файла

        Path directoryPath = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\M");
        Path directoryBPath = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\B");
        // Files.copy(filePath, directoryPath.resolve(filePath));// копируем созданный файл в директорию М и добавляем соответственно в путь
        // filePath - что копируем, directoryPath - куда копируем, resolve(filePath) - присоединяем путь filePath к пути directoryPath
        // если повторно вызвать то НЕ будет презаписи, а будет выброш исключение. Для перезапси нужно дописать в параметрах StandardCopyOption.REPLACE_EXISTING
        // Files.copy(filePath, directoryPath.resolve("test16.txt"));// копирование файла в папку и назначаем другое имя
//        Files.copy(filePath, directoryPath.resolve(filePath)
//                , StandardCopyOption.REPLACE_EXISTING);// перезаписывает файл в папке. Если просто вызвать resolve то выбросит искл т.к. файл уже есть

//        Files.copy(directoryBPath, directoryPath.resolve("B"));// копирует только папку В(без содержимого) в папку М
//        Files.move(filePath, directoryPath.resolve("test15.txt"));// перемещает файл, т.е. удаляется с прежнего места и появл. в новом месте

        //       Files.move(Paths.get("text5.txt"), Paths.get("text12.txt"));// Переименование - перемещаем и переназываем в новом месте. По сути перемещает и вставляетв ту же папку, но с новым именем.
        // Files.createFile(Paths.get("testTest.txt"));
        // Files.delete(Paths.get("testTest.txt"));
  //      Files.delete(Paths.get("M"));// удаляет папку только если она пустая

        System.out.println("Done!");


        System.out.println("======================================");
    }
}
