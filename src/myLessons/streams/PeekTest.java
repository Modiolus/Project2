package myLessons.streams;

import java.util.List;
import java.util.stream.Stream;

public class PeekTest {
    public static void main(String[] args) {
        //Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        /*метод peek работает аналогично методу forEach - выводит на экран
         * НО peek это intrmediate метод и поэтому используется для вывода промежуточных результатов
         * в данном случае peek показывает промеж действие в виде уникальных элементов после distinct*/
        List<Integer> list = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        long result = list.stream()
                .distinct()
                .peek(System.out::println).count();

        System.out.println("result-> " + result);

    }
}
