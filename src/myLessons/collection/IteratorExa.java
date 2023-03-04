package myLessons.collection;

import java.util.*;

public class IteratorExa {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("test");
        list.add("ets");
        list.add("acer");
        list.add("asus");
        list.add("lg");

        // List<String> list3 = new LinkedList<>();
        List<String> linkedList = new LinkedList<>();
        ListIterator<String> listIterator = linkedList.listIterator();// позволяет проходиться в одну и в другую сторону по колллекции
        listIterator.previousIndex();
        listIterator.hasPrevious();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("ets")) {
                list.remove(1);
                List<String> list2 = Collections.singletonList(iterator.next());
                System.out.println(list2);
            }
        }

    }
}
