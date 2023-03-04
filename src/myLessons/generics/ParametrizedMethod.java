package myLessons.generics;

import java.util.ArrayList;

public class ParametrizedMethod {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
//   ArrayList<Integer> arrayList = new ArrayList<>(); для JVM это без <> т.е. ArrayList arrayList = new ArrayList()
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(5);
        System.out.println(arrayList);

        int a = arrayList.get(0);

        /*JVM сначала arrayList.get(0) переводит в Object, потом
        кастит до Integer(т.к. мы указали его в <>): (Integer) arrayList.get(0)
        потом приводит это к int a int a =(Integer) arrayList.get(0);
        т.е. JVM стирает типы "Type erasure"! Это сделано для того, чтобы была обратная совместимость кода
        * */


        System.out.println(GenMethod.getSecondElement((arrayList)));

    }
}

class GenMethod {

    public <V> V TestMethod(V val) {
        return val;
    }

    public <T> T getSecondElement2(ArrayList<T> a1) {
        return a1.get(1);

    }

    public static <T> T getSecondElement(ArrayList<T> a1) {
        return a1.get(1);
    }
}
