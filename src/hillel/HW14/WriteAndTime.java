package hillel.HW14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteAndTime {
//    public static void primaryWrite(String str)
//            throws IOException {
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Projects\\Project2\\src\\hillel\\HW14\\result.txt"));
//        writer.write(str);
//
//        writer.close();
//    }
//
//    public void nextWrite(String str)
//            throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Projects\\Project2\\src\\hillel\\HW14\\result.txt", true));
//        writer.append("\n");
//        writer.append(str);
//
//        writer.close();
//    }
    public static void write (String st) throws IOException {
        File appDirectory = new File(FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString() + "\\src\\gameResult");
        appDirectory.mkdir();

        File dirFile = new File(appDirectory, "results.txt");

        FileWriter writer = new FileWriter(dirFile, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write(st);
        //  writer.append("\n");
        bufferWriter.close();
    }


    public static String time(String s) {
        LocalDateTime ldt = LocalDateTime.now();
        String str = s + ldt.format(DateTimeFormatter.ofPattern("dd.MM.yy" + "\nHH:mm:ss"));  //"\nДата и время: " +
        return str;
    }
}
