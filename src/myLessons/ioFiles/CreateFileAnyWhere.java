package myLessons.ioFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;

public class CreateFileAnyWhere {
    public static void main(String[] args) throws IOException {
        File appDir = new File(FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString()+ "\\src\\converted" ); //путь создания подпапки в src

        appDir.mkdir();

        File file = new File(appDir, "test.txt");// создание файла в созданной папке
        file.createNewFile();

    }
}
