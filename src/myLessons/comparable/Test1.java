package myLessons.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zaur");
        list.add("Ivan");
        list.add("Mariya");

        System.out.println("Pered sortirovkoy");
        System.out.println(list);

        Collections.sort(list); // здесь идет сортировка просто по словарю, автоматически

        System.out.println("Posle sortirovki");
        System.out.println(list);
    }
}
