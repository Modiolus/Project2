package myLessons.ioFiles.classFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("example1.txt");
        File file2 = new File("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\classFile\\A\\ttt.txt");
        File folder = new File("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\classFile\\A");
        File folder2 = new File("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\classFile\\B");
        folder.mkdir(); // создает директорию если таковой нет. Возвращает true если не было и false если уже есть
        folder2.mkdir(); // создает директорию если таковой нет ==//==
        file2.createNewFile(); // создает файл если такового нет ==//==
//        file.renameTo(new File("test16.txt")); // создает новый файли и переименовывает его

        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath(): " + folder.getAbsolutePath());
        System.out.println("=====================================================");
        System.out.println("file.exists(): " + file.exists());
        System.out.println("file2.exists(): " + file2.exists());
        System.out.println("folder.exists(): " + folder.exists());
        System.out.println("folder2.exists(): " + folder2.exists());
        System.out.println("======================================================");
        System.out.println("file.isDirectory(): " + file.isDirectory());
        System.out.println("folder.isDirectory(): " + folder.isDirectory());
        System.out.println("======================================================");
        System.out.println("file2.createNewFile(): " + file2.createNewFile());
        System.out.println("folder2.mkdir(): " + folder2.mkdir());// создает директорию
        System.out.println("folder.mkdir(): " + folder.mkdir());// создает директорию
        System.out.println("=========================================================");
        System.out.println("file2.length(): " + file2.length());
        System.out.println("folder.length(): " + folder.length());// не вычисляет напрямую размер папки- нужно писать код самому. Есть в следующих уроках
        System.out.println("=======================================================");
//        System.out.println(file2.delete());// удаляет файл
//        System.out.println(folder2.delete());// удаляет папку, если она пуста!

        File folder3 = new File("D:\\Projects\\Project2\\src\\myLessons\\ioFiles");
        File[] files = folder3.listFiles();// выводит путь содержимого папки (файлы и подпапки)

        System.out.println(Arrays.toString(files));
        System.out.println("==========================================================");
        System.out.println("file2.isHidden(): " + file2.isHidden());// скрыт или нет файл или папка
        System.out.println("file2.canRead(): " + file2.canRead());// доступна ли для чтения
        System.out.println("file2.canWrite(): " + file2.canWrite());// дступана ли для записи
        System.out.println("file2.canExecute(): " + file2.canExecute());// доступна ли для запуска

    }
}
