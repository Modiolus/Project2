package myLessons.streams;

import java.util.Arrays;

public class ForEachTest {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
        Arrays.stream(array).forEach(element -> System.out.println(element));
        Arrays.stream(array).forEach(System.out::println);// говорит: поставь эелементы из параметров в метод println класса System.out
        Arrays.stream(array).forEach(Utils::myMethod);//в качестве примера, чтобы понять как работает System.out::println
        Arrays.stream(array).forEach(element->Utils.myMethod(element));// тоже самое
        System.out.println("========================");

        Arrays.stream(array).forEach(element -> {
            element *= 2;
            System.out.println(element);
        });
    }
}

class Utils {
    public static void myMethod(int a) {
        a += 5;
        System.out.println("Element: " + a);
    }

}