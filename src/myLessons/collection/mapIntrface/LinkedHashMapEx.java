package myLessons.collection.mapIntrface;

import java.util.LinkedHashMap;

public class LinkedHashMapEx {
    public static void main(String[] args) {

        // данные в параметрах при желании можно прописать. Если поставить в конце false, то выводиться элементы будут в стандартном порядке
        // как мы их вводили. Если же поставить true, то элементы выводятся в том порядке,
        // в котором они были использованы в любых применяемых методах
        //Т.Е. в LinkedHashMap мы може хранить элемены в порядке добавления по умолчанию или порядке использования!
        LinkedHashMap<Double, StudentExa> lhm =
                new LinkedHashMap<>(16, 0.75f, true);

        StudentExa st1 = new StudentExa("Zaur", "Tregulov", 3);
        StudentExa st2 = new StudentExa("Mariya", "Ivanova", 1);
        StudentExa st3 = new StudentExa("Sergey", "Petrov", 4);
        StudentExa st4 = new StudentExa("Igor", "Sidorov", 2);
        lhm.put(7.2, st3);
        lhm.put(6.4, st2);
        lhm.put(7.5, st4);
        lhm.put(5.8, st1);

        System.out.println(lhm.get(5.8));
        System.out.println(lhm.get(7.5));


        System.out.println(lhm);
    }
}
