package myLessons.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctTest {
    public static void main(String[] args) {
        /*метод distinct() выводит уникальные элементы*/
        /*можно перед distinct прописать метод unordered - не будет обращать внимание на пордок итогда вернется Set.
         * Это позволит ускорить работу программы*/
        //  Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        List<Integer> list = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        list.stream()
                .distinct()
                .forEach(System.out::println);
        // stream1.distinct().forEach(System.out::println);

        Stream<String> stream2 = Stream.of("Ivanov", "Petrov", "Sidorov", "Ivanov");
        stream2.distinct().forEach(System.out::println);

        /*разными путями выводим элемент содержащий букву е */
        List<String> list1 = List.of("Acer", "Asus", "Apple");

        for (String s : list1) {
            if (s.contains("e")) {
                System.out.println("If -> " + s);
            }
        }
        System.out.println("----------->");

        list1.stream()
                .filter(a -> a.contains("e"))
                .forEach(System.out::println);

        System.out.println("<------------");

        list1.stream().filter(e -> {
            if (e.contains("e")) {
                System.out.println("Stream-> " + e);
            }
            return false;
        }).collect(Collectors.toList());


    }
}
