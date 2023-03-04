package myLessons.collection.listInterface;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExmpl {

    public boolean addArray(LinkedList<String> linkedList, String[] array) {

        for (String s : array) {

            linkedList.add(s);
        }
        return true;
    }

    public static void main(String[] args) {

        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.add("Ivan");
        linkedList1.add("Petr");
        linkedList1.add("Mikhail");
        System.out.println(linkedList1.indexOf("Mikhail"));
        linkedList1.offer("Sveta");// offer- метод очереди Que
        System.out.println(linkedList1.indexOf("Sveta"));



        LinkedListExmpl linkedListExmpl = new LinkedListExmpl();
//        String[] arr = {"Masha", "Ira", "Sveta" };
//        linkedListExmpl.addArray(linkedList1, arr);

        System.out.println(linkedList1);

        //   System.out.println(linkedList1.get(0));

    }
}
