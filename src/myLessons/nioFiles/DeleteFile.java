package myLessons.nioFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFile {
    // способ удаления с их содержимым. Ранее нам удавалось удалять только пустые папки в этом уроке-> nioFiles\PathAndFilesEx2
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\CopyHere");
        Files.walkFileTree(path, new MyFleVisitor3());


    }
}

class MyFleVisitor3 extends SimpleFileVisitor<Path> {
    // сначала удаляем содержимое папки, а потом и саму папку
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Delete file: " + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Delete Directory: " + dir.getFileName());
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}
