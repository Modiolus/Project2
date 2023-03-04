package myLessons.nioFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFile3 {
    public static void main(String[] args) throws IOException {
        // здесь показан способ копирования папок с их содержимым. Т.е. копирование не пустых папок
        Path source = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\X");
        Path destination = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\CopyHere");
        Files.walkFileTree(source, new MyFileVisitor2(source, destination));
        // в скобках source - это где будем ходить, а new MyFileVisitor2(source, destination) - что будем делать..
    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    // extends SimpleFileVisitor<Path> (имплементит FileVisitor) позволяет переопределить только необходимые нам методы
    Path source; // это D:\Projects\Project2\src\myLessons\nioFiles\X
    Path destination; // это D:\Projects\Project2\src\myLessons\nioFiles\CopyHere

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }
    // сначала копируем папки, а затем их содержимое
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(dir));
        Files.copy(dir, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(file));
        Files.copy(file, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}
