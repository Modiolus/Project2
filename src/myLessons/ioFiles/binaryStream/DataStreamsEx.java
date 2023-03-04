package myLessons.ioFiles.binaryStream;

import java.io.*;

public class DataStreamsEx {
    public static void main(String[] args) {
        /*DataInputStream и DataOutputStream используются для записи в файл и чтения из него
         * примитивных типов данных*/
        // содержимое файла прочитать человек не может т.к. он бинарный(будут не понятные символы в созданном файле my_test.bin)
        //поэтому используем sout чтобы видеть, что запись прошла
        // на всякий случай: чтобы записать числа в текстовый файл то можно
        // использовать BufferedWriter и запистаь в файл txt так по примеру
        //int i = 5;
        //double d=3.14;
        //boolean b = true;
        //writer.write(String.valueOf(i));
        //writer.write(String.valueOf(d));
        //writer.write(String.valueOf(b));
        try (
                DataOutputStream outputStream = new DataOutputStream(
                        (new FileOutputStream("my_test.bin"))); // пишем сначала outputStream т.е. где создавать и куда писать
                DataInputStream inputStream = new DataInputStream(
                        new FileInputStream("my_test.bin"))
// пишем и читаем с одного и того же места. В данном случае нет смысла создавать другой файл т.к. мы не увидим там данные,
// а выводим просто в консоль для визуализации

        ) {
            outputStream.writeBoolean(true);
            outputStream.writeByte(5);
            outputStream.writeShort(120);
            outputStream.writeInt(500);
            outputStream.writeLong(1000_000);
            outputStream.writeFloat(3.14F);
            outputStream.writeDouble(123.456);
// т.к. файлы бинарные то мы не сможем их прочитать в созданном файле. Чтобы их просмотерть мы выводим через sout
// обязательно соблюдаем последовательность чтения соотвественно последовательности записи
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        {

        }

    }

}
