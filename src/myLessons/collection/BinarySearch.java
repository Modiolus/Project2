package myLessons.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(12);
        arrayList.add(-8);
        arrayList.add(0);
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(150);
        arrayList.add(-30);
        arrayList.add(19);

/*
binarySearch является методом класса Collections
для того чтобы найти например элемент 12 нужно сначала отсортировать
коллекцию, а затем применить метод binarySearch
binarySearch - метод который ускорят поиск элемента, за счет того что сначала делит колекцию пополам
а затем сравнивает искомый элемент с срединным и в результате
берет правую или левую половину для сравнения в зависимости от результата
т.е. binarySearch работает только в отсортированной коллекции
*/
        System.out.println("Original " + arrayList);
        Collections.sort(arrayList);
        int index1 = Collections.binarySearch(arrayList, 12);
        System.out.println("Avers sort " + arrayList);
        System.out.println("Index " + index1);

        Collections.reverse(arrayList);
        System.out.println("Revers sort " + arrayList);
        Collections.shuffle(arrayList);
        System.out.println("Shuffle "+arrayList);


    }

}
