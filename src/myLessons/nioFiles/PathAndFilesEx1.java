package myLessons.nioFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PathAndFilesEx1 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\M");

        System.out.println("filePath.getFileName(): " + filePath.getFileName());
        System.out.println("directoryPath.getFileName(): "
                + directoryPath.getFileName());// возращает имя файла или директории, кторые рапсоложены по данному пути
        System.out.println("=====================================");
        System.out.println("filePath.getParent() " + filePath.getParent());
        System.out.println("directoryPath.getParent() "
                + directoryPath.getParent());// возвращает родителя или null если файла или директории не существует
        System.out.println("======================================");
        System.out.println("filePath.getRoot() " + filePath.getRoot());//корень откуда берет начало файл или директория
        System.out.println("directoryPath.getRoot() "
                + directoryPath.getRoot());
        System.out.println("======================================");
        System.out.println("filePath.isAbsolute() " + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute() "
                + directoryPath.isAbsolute());// возварщает true если путь абсолютный иначе false
        System.out.println("======================================");
        System.out.println("filePath.toAbsolutePath() " + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath() "
                + directoryPath.toAbsolutePath());// показывает абсолютный путь(даже если был указан просто относительный)
        System.out.println("======================================");
        System.out.println("filePath.toAbsolutePath().getParent() "
                + filePath.toAbsolutePath().getParent());// определяет абсолютный путь и выводит родителя
        System.out.println("directoryPath.toAbsolutePath().getParent() "
                + directoryPath.toAbsolutePath().getRoot());// определяет абсолютный путь и выводит корень
        System.out.println("======================================");
        System.out.println("directoryPath.resolve(filePath) "
                + directoryPath.resolve(filePath));// присоединяет к directoryPath filePath

        System.out.println("======================================");
        Path anotherPath = Paths.get("D:\\Projects\\Project2\\src" +
                "\\myLessons\\nioFiles\\M\\N\\Z\\test20.txt");
        System.out.println("directoryPath.relativize(anotherPath) "
                + directoryPath.relativize(anotherPath));// ищем относительный путь anotherPath относительно другого пути directoryPath

        System.out.println("======================================");
        if (!Files.exists(filePath)) { // существует ли filePath?
            Files.createFile(filePath); // создает указанный файл
            // код создаёт директорию или файл соответственно, если его соответственно не существует
        }
        if (!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath);// создаёт указанную директорию
        }
        System.out.println("Files.isReadable(filePath) "
                + Files.isReadable(filePath));// разрешён ли для чтения файл
        System.out.println("Files.isWritable(filePath) "
                + Files.isWritable(filePath));// разрешён ли для записи файл
        System.out.println("Files.isExecutable(filePath) "
                + Files.isExecutable(filePath));// разрешён ли для запуска файл
        System.out.println("======================================");

        Path filePath2 = Paths.get("D:\\Projects\\Project2\\test15.txt");
        System.out.println("Files.isSameFile(filePath, filePath2) "
                + Files.isSameFile(filePath, filePath2)); // проверяет ссылаются ли эти пути на один и тот же файл
        System.out.println("======================================");
        System.out.println("Files.size(filePath) "
                + Files.size(filePath));// выводит размер файла байтах
        System.out.println("======================================");
        System.out.println("Files.getAttribute(filePath, \"creationTime\") "
                + Files.getAttribute(filePath, "creationTime"));// узнаёт инфрмацию о каком-то атрибуте. Атрибуты прописываются стандартно- можно загуглить
        System.out.println("======================================");
        System.out.println("Files.getAttribute(filePath, \"size\") "
                + Files.getAttribute(filePath, "size"));// атрибут размер
        System.out.println("======================================");
        Map<String, Object> attributes = Files.readAttributes(filePath, "*");// выводит все атрибуты и возвращает в мапу
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        attributes.forEach((w, r)-> System.out.println(w + " : "+ r)); // просто как пример, еще способ вывода мапы через лямбду
        System.out.println("======================================");


    }
}
