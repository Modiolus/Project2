package hillel.listHW9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Link {
    String value;
    Link next;
    Link prev;

    public Link(String value) {
        this.value = value;
    }

    public void displayLink() {

        System.out.print(value + " "); // вывод

    }
}
class FirstLastList {    // проверить нужно ли  extends CollectionEx
    private Link first;
    private Link last;
    int size = 0;
    int index = 0;

    public int size() {
        return size;
    }

//    public FirstLastList() {          // конструктор по умолчанию - необязателен
//    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(String str) {
        Link newLink = new Link(str);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(String str) {
        Link newLink = new Link(str);
        if (isEmpty()) {
            first = newLink;
        } else
            last.next = newLink;
        last = newLink;
        newLink = first.prev;
       // System.out.println(last.next);

        size++;
    }

    public void displayList() {
        System.out.print("List: ");
        Link current = first;  // current-у присваивается ссылка первого элемента из FirstLastList
        while (current != null) {
            current.displayLink();

            current = current.next;

        }
        System.out.print(" " + "\n");

    }

    public boolean addAll(String[] strArr) {

        for (String s : strArr) {
            add(s);
        }

        return true;
    }

    public boolean addAll(Collection strColl) {
        for (Object st : strColl) {
            add((String) st);
        }
        return true;
    }

    public boolean add(String str) {
        // insertFirst(str);
        insertLast(str);

        return true;

    }
//
//    public boolean delete(String st) {
//
//        last.next = null;
//        last.prev = null;
//
//        size--;
//
//        return true;
//    }

//    public boolean delete (String st) {  // ДУМАЕМ!!!!!!!!!!!!
//
//        String[] ar = new String[size];
//        for (int i = 0; i < size; i++) {
//            ar[i] = last.value;
//        }
//        for (int i = 0; i < size; i++) {
//           if (last.value == st) {
//              Link temp = last.prev;
//              Link temp2 = last.next;
//
//           }
//        }
//        size--;
//        return true;
//    }

    public boolean delete(int index) {

        for (int i = 0; i < size; i++) {
            if (i == index){
                System.out.println();
                first = null;
                Link temp = last.next;

            }
        }
        size--;
        return true;
    }

    public static void main(String[] args) {

        FirstLastList theList = new FirstLastList();
        theList.add("Samsung");
        theList.add("Apple");
        theList.add("Xiaomi");
        theList.add("Acer");
        theList.displayList();
        System.out.println("Size: " + theList.size());

        String[] array = {"Dell", "HP", "Philips"};
        theList.addAll(array);
        theList.displayList();

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("Lenovo");
        arrList.add("Seiko");
        arrList.add("Citizen");

        theList.addAll(arrList);
        theList.displayList();
        System.out.println("===============================");

       // theList.delete("Apple");
        theList.delete(2);
        theList.displayList();
        System.out.println("Size: " + theList.size());

    }


//public static void main(String[] args) {
//    LinkedList<String> list = new LinkedList<>();
//    String s = " ";
//    s.trim();
//
//    System.out.println(s);
//
//}


}
