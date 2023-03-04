package hillel.lesson18;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

public class CreateFileOnAnyDevice {
    public static void main(String[] args) throws IOException {
//        File appDirectory = new File(FileSystems.getDefault()
//                .getPath("")
//                .toAbsolutePath()
//                .toString()+ "\\converted");
//
//        appDirectory.mkdir();
//        System.out.println("app location path : " + appDirectory);

/*!! Создание директории и файла на любом устройстве где будет запущен этот код*/
        File appDirectory = new File(FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString()+ "\\src\\converted" );//путь создания подпапки в src

        appDirectory.mkdir();

        File file = new File(appDirectory, "test.txt");// создание файла в созданной папке
        file.createNewFile();

    }
}
