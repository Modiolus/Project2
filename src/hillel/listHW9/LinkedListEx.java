package hillel.listHW9;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {


        LinkedList<String> list = new LinkedList<>();

        list.add("Samsung");
        list.add("Apple");
        list.add("Acer");
        list.add("Asus");
        System.out.println(list);


        list.add(1, "Dell");
        System.out.println(list);


        list.addFirst("Xiaomi");

        list.iterator();
        System.out.println(list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.contains(list);


    }
}
