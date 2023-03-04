package myLessons.ioFiles.traineIOFiles;

import java.io.*;
import java.math.BigInteger;

public class GeneralTrain {
    public static void main(String[] args) throws FileNotFoundException {
        // чтение из Word и запись в Word
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Андрей\\Desktop\\Doc1.docx"));
               // FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Андрей\\Desktop\\Doc1.docx");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Андрей\\Desktop\\Doc2.docx")))
           // FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Андрей\\Desktop\\Doc2.docx"))
             {
            int t;

            while ((t = bufferedInputStream.read()) != -1) {

                bufferedOutputStream.write(t);
               // fileOutputStream.write(BigInteger.valueOf(t).toByteArray(), 1, 5);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

