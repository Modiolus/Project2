package myLessons.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatTest {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream3 = Stream.of(6, 7, 8, 9, 10);
        /*метод concat является статическим поэтому его так просто не вызовешь, а только через Stream */
        Stream<Integer> stream4 = Stream.concat(stream2, stream3);
        stream4.forEach(System.out::println);

//        =======================================================
//        пример ниже просто показать как можно объединить два листа
        List<String> list = List.of("Ivanov", "Petrov", "Sidorov", "Ivanov");
        List<String> list1 = List.of("Acer", "Asus", "Apple");
        Stream<String> s1 = list.stream();
        Stream<String> s2 = list1.stream();
        // конкантенирует стримы а не листы!!!
        List<String> res = Stream.concat(list.stream(), list1.stream()).collect(Collectors.toList());
        System.out.println(res);


        List<String> list2 = new ArrayList<>(list);
        list2.addAll(list1);
        System.out.println(list2);

        List<String> list3 = Stream.of(list, list1)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("Add throw stream: " + list3);


    }
}
