package myLessons.nioFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChanBufMethods {
    public static void main(String[] args) {
        try (RandomAccessFile file =
                     new RandomAccessFile("text5.txt", "r");
             FileChannel channel = file.getChannel()) {
// документация с описанием методов ByteBuffer https://docs.oracle.com/javase/7/docs/api/java/nio/ByteBuffer.html
            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            //после этих выводов курсор находится на позиции 3 после вывода 3-х байт
            buffer.rewind(); // перевоит курсор снова в позицию 0
            System.out.println((char) buffer.get());
            System.out.println("====================================");

            buffer.compact();
            //buffer.clear();
            // похож на clear, но он копирует непрочитанные элементы в начало буфера и буфер готов записывать в себя байты
            // но уже начиная с пустой позиции(ниже после байтов) и соответственно не затирает байты
            // т.е. используем когда нужно не потярять наши байты
            channel.read(buffer);

            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            System.out.println("===========================================");
            buffer.clear();
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());
                buffer.mark();// ставим пометку на по position а он на символе h
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            buffer.reset();// позиция меняется на то место где стоит пометка

            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
