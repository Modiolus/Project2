package myLessons.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        double sum = list.stream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println(sum);
        // Это возможность использовать несколько ядер процессора при выполнении операций стрим
        //Используется чаще при агрегирующих функциях типа суммы, мин, макс и т.д.
        /*при использовании parallelStream() для малого количества элементов выйдет ошибочный результат
        * поэтому parallelStream() необъходиомо использовать в крайних случаях когда нужно призводить
        * операции с большим количеством элементов типа миллиард
        * т.к. происходит деление потоков между ядрами и при малом количестве выходит ошибочный резльтат*/
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            l.add(i+1);
        }
        System.out.println(l);
        double division = l.parallelStream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println(division);

    }
}
