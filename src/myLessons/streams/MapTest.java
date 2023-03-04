package myLessons.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Privet");
        list.add("Kak dela?");
        list.add("Ok");
        list.add("Poka");
// код ниже классически без стримов
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
//        System.out.println(list);
        /*мап преобразовывает каждый элемент потока в то, что мы опишем в параметрах
         * методы стрима не меняеют коллекцию или массив.. поэтому присваивать нужно всё к другой коллекции list2*/
        List<Integer> list2 = list.stream()//list.stream() переводит в поток элементы list-a
                .map(element -> element.length())// Function<T, R>  получает String, возвращает int
                .collect(Collectors.toList());
        System.out.println(list2);
        /*задача вывести: если элемент делится без остатка на 3, то вывести этот элемент деленный на 3
         * иначе просто вывести эелемент в неизменном состоянии */
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array)
                .map(element -> {
                    if (element % 3 == 0) {
                        element = element / 3;
                    }
                    return element;

                }).toArray();
        System.out.println(Arrays.toString(array));
    }
}
