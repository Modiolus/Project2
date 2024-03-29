package myLessons.nioFiles;

import myLessons.ioFiles.RandomAccessFileEx;

import javax.swing.plaf.ButtonUI;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelBufferEx1 {
    // читаем с файла в чанел, из чанела записывем в буфер, а из буфера выводим
    // читаем из буфера в чанел и пишем в файл
    public static void main(String[] args) throws IOException {

        try (RandomAccessFile file =
                     new RandomAccessFile("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\test11.txt", "rw");
             FileChannel channel = file.getChannel()) { // из файла получаем канал

            //limit - крайняя ячейка, до которой можно читать или записывать
            // limit не будет равен capacity в конце когда записалось например 5 байти при capacity =25. limit чтения в таком случае будет 5
            ByteBuffer buffer = ByteBuffer.allocate(25);// allocate - пер. выделить, capacity -> указываем на сколько байт будет буфер
            // есть такеже понятие position - это позиция курсора и начинается с 0 (как в массвие)
            // максимальная position = capacity -1 (как в массвие)
            StringBuilder stix = new StringBuilder();
            int byteRead = channel.read(buffer);// читаем с помощью channel из файла, и ЗАПИСЫВАЕМ в buffer
            while (byteRead > 0) {// если = 0 то курсор стоит вначале и тогда flip  не нужен
                System.out.println("Read " + byteRead); // выводим на экран количество прочитанных байт. На каждой итерации оно будет не более 25
                buffer.flip();
                //flip пер. с анг. кувырок или сальто. Меняет режим буфера из режима "записи" в буфер в режим "чтения"
                // т.е. переносится курсор с конца в начало в 0 позицию. Т.к после записи в буфер курсор находился в конце т.е. после capacity

                // в следующем while читаем из буфера
                while (buffer.hasRemaining()) {// пока у бефера остаётся, что читать
                    stix.append((char) buffer.get());
                    // читает и записывает по 1 байту в файл. Читает и добавляет именно buffer.get()
                    // + append добавляет в StringBuilder, чтобы мы могли далее вывести в консоль

                }
                // подготовим буфер к записи с помощью метода clear()
                buffer.clear();

                // меняет режим в "запись" и переносит position в 0, затем записывает в буфер новый бай в ячейку, а старый при этом затирает
                // т.е. запись происходит поверх старых байтов. Таким образом clear() факитчески не очищает буффер, а просто переносит курсор
                byteRead = channel.read(buffer);// снова читаем информацию из файла и записываемв буфер поверх имеющихся байтов
            }
            System.out.println(stix);
            // Другими словами прочитали и записали в буфер channel.read(buffer) строку в 25 байт, курсор стал в конце строки
            // перенсим курсор в начало buffer.flip(); чтобы прочиать из файла и записать новую строку в буфер или прочитать строку из буфера и
            // и записать её в файл. В зависимости, что нам нужно
            // одновременно из буфера записываем обратно в файл пока в буфере есть что читать buffer.hasRemaining()
            // читаем и засписываем из буфера в файл и курсор становится снова в конце строки
            // переносим курсор в начало строки buffer.clear();
            // !! flip переводит limit в предыдущее значение курсора(если capacity был 25 а колич записанных байт 12, то limit будет 12)
            // в самом начале соответсвенно limit = capacity
            // clear делает limit = capacity, чтобы подготовить буфер для записи, чтобы использовать весь буфер. Запись идёт поверх сещуств байт.
            // https://docs.oracle.com/javase/7/docs/api/java/nio/Buffer.html#clear() о методах flip, clear, rewind

            /*запись информации через буфер обратно в файл*/
            String text = "\nThere are only two ways to live your life." +
                    "One is as though nothing is a miracle. " +
                    "The other is as though everything is.";
// I способ========================
            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length); // длина массива байтов
            buffer2.put(text.getBytes());// записали сторку в буфер
            buffer2.flip();// перебросили в начало для чтения
            channel.write(buffer2);// чтение из буфера и запись в channel и в файл
// II способ========================
            //       ByteBuffer buffer2 = ByteBuffer.wrap(text.getBytes());
            // wrap записывает в буфер и создает необходимый рамер буфера
            // плюс переводит в режим чтения вместо flip
            //      channel.write(buffer2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//!!!! М Е Т О Д Ы    Б У Ф Е Р А
// allocate (intacity) — Этот метод используется для выделения нового буфера с емкостью в качестве параметра.
// Метод Allocate выдает исключение IllegalArgumentException в случае, если переданная емкость является отрицательным целым числом.
//
//read () и put () — метод чтения канала используется для записи данных из канала в буфер,
// а put — метод буфера, который используется для записи данных в буфер.
//
//flip () — Метод flip переключает режим буфера с режима записи на режим чтения.
// Он также устанавливает позицию обратно в 0 и устанавливает limit, в котором позиция была во время записи.
//
//write () и get () — метод записи канала используется для записи данных из буфера в канал,
// в то время как get является методом буфера, который используется для чтения данных из буфера.
//
//rewind () — метод перемотки используется, когда требуется перечитывание, так как он устанавливает позицию в ноль
// и не изменяет значение лимита.
//
//clear () и compact () — clear и compact оба метода используются для перехода из режима чтения в режим записи.
// Метод clear () устанавливает позицию в ноль и ограничивает ее до емкости, в этом методе данные в буфере не очищаются, только маркеры инициализируются повторно.
//
//С другой стороны, метод compact () используется, когда осталось несколько непрочитанных данных,
// и все же мы используем режим записи буфера, в этом случае компактный метод копирует все непрочитанные данные в начало буфера и устанавливает положение сразу после последнего непрочитанного элемента. Свойство limit все еще установлено в емкость.
//
//mark () и reset () — Как следует из названия, метод mark используется для пометки какой-либо конкретной позиции в буфере,
// в то время как сброс делает положение обратно в отмеченную позицию mark.