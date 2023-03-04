package myLessons.ioFiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomAccessFileEx {
    // позволяет читать информацию из любого места файла(средина, конец и т.д.) и записывать в любое место файла
    // происходит наподобие установки курсора в необходимое место
    // ранне рассматриваемые классы могли работать с иформацией последовательно и полностью
    // в этом видео №98 не все корректно работает применительно к кириллице
    public static void main(String[] args) throws InterruptedException {
        try (RandomAccessFile file =
                     new RandomAccessFile(new File("test10.txt"), "rw")) {//rw обозначает что мы будет писать и читать
            //System.out.println("Read-> "+(char)file.read());
            //=======================================================
            // !!!Правильный вывод строки на любом языке

            String s1 = file.readLine();
            String strUtf8 = new String(s1.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(strUtf8);
            //=============================================================
            // ===============================================================
            // Вывод любого символа на любом языке. На латинице просто справляется метод read()
            System.out.println();
            byte[] b = s1.getBytes();
            System.out.println("Out-> " + file.read(b));// количество байт строки
            System.out.println("Символ на позиции 0 -> "+charRead("test10.txt", 0));// вывод через написанный метод ниже

            char[] array = strUtf8.toCharArray();
            System.out.println("вывод-> " + array[0]); // вывод символа

            long position = file.getFilePointer();// место нахождения курсора
            System.out.println("Курсор на позиции -> "+position);
            //======================================================================
            //Одная латинская буква соответствует 1 байту, а кириллическая 2 байта
            //Это надо учитывать чтобы запись была корректной
// ищем и выводим строку С указанной позиции на любом языке. seek() - это искать
            file.seek(3);
            String str1 = file.readLine();
            String str1Utf8 = new String(str1.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("C 3 позиции -> " + str1Utf8);

            //!!!!!Одная латинская буква соответствует 1 байту, а кириллическая 2 байта
            //Это надо учитывать чтобы запись была корректной

            // String utf = new String(s3.getBytes("ISO-8859-1"), "UTF-8");
            // file.writeBytes(s3); // !!!в видео неверно т.к. пишет аброказябры с латиницы
            //Правильная запись в файл независимо от языка
            //String s3 = "Privet";
            String s3 = "Приветтт"; // 8 символов точно станут на 8 символов файле и все будет корректно
            byte[] bytes = s3.getBytes();
            //String s = new String(s3.getBytes(StandardCharsets.UTF_8));
            file.write(s3.getBytes(StandardCharsets.UTF_8)); // !!!такой метод записывает всё чётко неависимо латинца или кирилица
// запись происходит с новой строки т.к. первую строку мы прочитали и курсор усановился с начала второй строки
//=========================================================================

//randomWrite("test10.txt", 0);
            //randomRead("test10.txt", 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char charRead(String path, int position) {
        char[] ar = null;
        try (RandomAccessFile f = new RandomAccessFile(path, "rw")) {
            String line = f.readLine();
            String utf8 = new String(line.getBytes("ISO-8859-1"), "UTF-8");
            ar = utf8.toCharArray();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar[position];
    }


    public static void randomRead(String path, int point) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
//          String st = raf.readLine();
//            int c =st.getBytes()[0];
//            System.out.println("ReAD"+(char) c);

            raf.seek(point);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(buff)) == 0) {
                System.out.println("randomRead \n" + new String(buff, 0, hasRead));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
