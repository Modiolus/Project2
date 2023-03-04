package myLessons.ioFiles.binaryStream.programmer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx2 {
    public static void main(String[] args) {
        Car car = new Car("Nissan Tiida", "white");

        Employee employee = new Employee(
                "Mariya",
                "Ivanova",
                "IT",
                32,
                500,
                car);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("employees2.bin")
        )) {

            outputStream.writeObject(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
