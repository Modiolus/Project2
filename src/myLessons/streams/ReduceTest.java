package myLessons.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        Integer res = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            res = res * list.get(i);
        }

        System.out.println(res);

        /* тоже самое, что выше только через stream*/
        // используется метод get() от Optional, который обрабатывает искл в случае если accumulator равен 0
        // если вместо result будет Optional<Integer> o = то метод get() не нужен
        // accumulator - это первый элемент типа int res = 0, котрый затем умножается на element и результат
        // записывется в accumulator и снова умножается на element и т.д.

        int result = list.stream()
                .reduce((accumulator, element) ->
                        accumulator * element).get();


        System.out.println(result);

        int result2 = list.stream().reduce(1, (accumulator, element) ->
                accumulator * element);// т.к. в данном случае accumulator равен 1, то метод get() не нужен
        //identity указывает конкретное число с которого начинется действие, в данном случае умножение
        //т.е указывает первичное значение аккумулятора, которому в данном случае присваивается значение 1
        System.out.println(result2);

        /*ниже пример со String */
        List<String> list3 = new ArrayList<>();
        list3.add("Privet");
        list3.add("Kak dela?");
        list3.add("Ok");
        list3.add("Poka");

        String result3 = list3.stream().reduce((a, e) -> a + " " + e).get();
        System.out.println(result3);
        System.out.println("ONE ->> " + list.stream().reduce((s, f) -> s * f).get());


    }
}
