package myLessons.ioFiles.binaryStream.programmer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        /* Сериализация это процесс преобразования объекта в последовательность байт (ObjectInputStream)
         * Десериализация это процесс восстановления объекта из этих байт
         * */
        List<String> employees = new ArrayList<>();
        employees.add("Zaur");
        employees.add("Ivan");
        employees.add("Elena");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("employees1.bin") // файл создасттся, если его не было
        )) {
            outputStream.writeObject(employees);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
