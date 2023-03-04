package myLessons.generics;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        List<Number> list1 = new ArrayList<Integer>(); // так писать нельзя, типы должны совпадать
//        List<Object> list2 = new ArrayList<Integer>(); // так писать нельзя, типы должны совпадать
        /*<?> - любой класс
        * <? extends X> - класс X или любой его сабкласс
        * <? super Y> - класс Y или любой его суперкласс*/

        List<?> list3 = new ArrayList<Integer>();  // так писать можно. ? - это Wildcard и является супертипом
        List<? extends Object> list6 = new ArrayList<Integer>(); // так писать можно

        //пример использования=================================
        List<Double> list4 = new ArrayList<>();
        list4.add(3.14);
        list4.add(3.15);
        list4.add(3.16);
        showListInfo(list4);
        System.out.println("Sum of the lists elements = "+sum(list4));

        List<String> list5 = new ArrayList<String>();
        list5.add("Ok");
        list5.add("Privet");
        list5.add("Poka");
        showListInfo(list5);

    }

    public static void showListInfo(List<?> list) {
        System.out.println("Содержимое листа: " + list);
    }

    public static double sum(List<? extends Number> arrayList) {
        double sum = 0;
        for (Number n : arrayList) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
