package myLessons.nioFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class FileTree {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\X");
        Files.walkFileTree(path, new MyFileVisitor());

    }
}

class MyFileVisitor implements FileVisitor<Path> {
    // если НЕ нужны все методы то нужно унаседоваться от класса SimpleFileVisitor<Path> который имплементит интерфейс FileVisitor
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        System.out.println("Enter to directory: " + dir);

        return FileVisitResult.CONTINUE; // продолжает обход по файлам
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error while visiting file: " + file.getFileName());
        return FileVisitResult.TERMINATE; // немедленно прекращает обход по файлам
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from Directory: " + dir);
        return FileVisitResult.CONTINUE;
    }
    /* ещё существуют:
    * SKIP_SUBTREE  означает что в данную дерикторию заходить не надо
    * SKIP_SIBLINGS означает что в данной дериктории не нужно делать обход по файлам*/
}

