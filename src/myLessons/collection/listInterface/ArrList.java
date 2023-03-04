package myLessons.collection.listInterface;

import java.util.*;
import java.util.logging.Logger;

public class ArrList {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList();

        list.add("test");
        //list.add(2);
        list.add("ets");
        list.add("acer");

        String[] array1 = list.toArray(new String[0]);
        for (String s : array1)
            System.out.println(s);


        //  System.out.println(list);
        for (Object o : list)
            System.out.println(o + " Length: " + ((String) o).length());

//        List<String> list1 = new ArrayList<>();
//        list1.add("Ferrari");
//        list1.add("Skoda");
//        list1.add("dacia");
//        System.out.println("ListCar "+list1);

        Integer[] array = new Integer[2];
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));

    }


}

class Car {

}


