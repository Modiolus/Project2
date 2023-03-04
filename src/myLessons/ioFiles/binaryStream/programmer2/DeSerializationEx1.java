package myLessons.ioFiles.binaryStream.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeSerializationEx1 {
    public static void main(String[] args) {
        /*Сериализация это процесс преобразования объекта в последовательность байт (ObjectInputStream)
        * Десериализация это процесс восстановления объекта из этих байт
        * */
        List<String> empl;

        try(ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("employees1.bin")
        )){
           empl = (ArrayList)inputStream.readObject();
            System.out.println(empl); // выводим в консоль т.к. в файле бинарные файлы для человека не читабельны
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
