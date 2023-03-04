package myLessons.ioFiles.binaryStream;

import java.io.*;

public class CopyExFileIOStream {
    public static void main(String[] args) {
        // FileInputStream и FileOutputStream используются для чтения\записи бинарных файлов(не видимых человеку)
        // например фото или видео
        // буфферизация рботает аналогично BufferedFileReader\BufferedFileWriter
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Андрей\\Desktop\\Dog.jpg");
             FileOutputStream outputStream = new FileOutputStream("Dog.jpg"))
        // если хотим записать в папку на жест диске, то указываем путь к паке
        // и в конце добавляем название файла например \\Dog.jpg

        {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //=================================================================
        // чтение из Word и запись в Word
        try (FileInputStream fileInputStream = new FileInputStream("D:\\Doc1.docx");
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\Doc2.docx")) {
            int t;

            while ((t = fileInputStream.read()) != -1) {

                fileOutputStream.write(t);
                // fileOutputStream.write(BigInteger.valueOf(t).toByteArray(), 1, 5);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
