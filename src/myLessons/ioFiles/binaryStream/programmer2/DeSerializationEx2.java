package myLessons.ioFiles.binaryStream.programmer2;

import myLessons.ioFiles.binaryStream.programmer1.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeSerializationEx2 {
    public static void main(String[] args) {
        Employee bestEmployee;

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("employees2.bin")
        )){
          bestEmployee=(Employee) inputStream.readObject();

            System.out.println(bestEmployee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
