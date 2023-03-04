package hillel.example;

import java.util.ArrayList;
import java.util.Collection;

public class List implements ListInterface {
    private Node head;
    private Node tail;
    int size;

    public List() {
        head = null;
        tail = null;

    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean add(String str) {
        Node temp = new Node(str);
        if (isEmpty()) {         // сюда программа зайдёт только вначале, когда список пустой
            head = temp;

        } else
            tail.next = temp;  // ссылка next старого tail ссылается на temp(новый элемент)
        temp.prev = tail;
        tail = temp;         // новому tail-у присваивается новый элемент

        size++;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {

        for (String st : strArr) {
            add(st);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        for (Object s : strColl) {
            add((String) s);
        }

        return true;
    }

    public void print() {
        System.out.print("List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    @Override
    public boolean delete(int index) {
        Node cur = head;
        int c = 0;
        while (cur != null && c != index) {
            cur = cur.next;
            c++;

        }
        if (index == 0) {
            head = cur.next;
        } else
            cur.prev.next = cur.next;

        size--;
        return true;
    }

    @Override
    public boolean delete(String str) {

        for (Node curr = head; curr != null; curr = curr.next) {

            if (str.equals(head.data)) {
                head = curr.next;
            } else if ((str.equals(curr.data))) {
                curr.prev.next = curr.next;
            }
        }
        size--;
        return false;
    }

    @Override
    public String get(int index) {
        Node cur = head;
        int c = 0;
        while (cur != null && c != index) {
            cur = cur.next;
            c++;
        }
        System.out.println();
        return cur.data;
    }

    @Override
    public boolean contains(String str) {
        for (Node curr = head; curr != null; curr = curr.next) {
            if (str.equals(curr.data)) {
                System.out.println();
                return true;
            }
        }
        System.out.println();
        return false;
    }

    @Override
    public boolean clear() {
        for (Node curr = head; curr != null; ) {
            Node next = curr.next;
            curr.data = null;
            curr.next = null;
            curr.prev = null;
            curr = next;
        }
        head = tail = null;
        size = 0;

        return true;
    }

    @Override
    public boolean trim() {
        return true;
    }

    @Override
    public boolean compare(List coll) {
//
//        for (Node curr1 = head; curr1 != null; curr1 = curr1.next) {     //Node temp = new Node(str); Node
//            for (Node curr2 = head; curr2 != null; curr2 = curr2.next) {
//                if (curr1.prev == curr2.prev && curr1.next == curr2.next) {
//                    return true;
//                } //else return false;
//            }
//        }

        //for (Node curr = head; curr != null; curr = curr.next) {

//        Node current = head;
//        while ((current != null&&coll!=null) && current.next == coll){
//            return true;
//        }
        //    Node current = head;
//        int index = 0;
//
//        if (size() == coll.size()) { //&& current.next.equals(coll.iterator())
        //if (Objects.equals(current.data., coll)) {
        //if (current.data.equals(coll.)){
//        if (current.data){
//            return true;
//        }
//                for (Node current = head; current != null; current = current.next) {
//                    for (Object s : coll) {
//                    //   for (int i = 0; i < coll.size(); i++) {
//                    if (s == (current.data)) {
//                        System.out.println(current.data);
//                       // current = current.next;
//                        return true;
//                   // }
//                }
        //  return true;
//            }

        //           }

        // }
//            if (contains(current.data) == coll.containsAll(coll))
//        return true;

//            if (curr1.prev == curr2.prev && curr1.next == curr2.next) {
//                return true;
//            }

        // if (this == coll) return true;
        if (size != coll.size()) return false;
        // List temp = coll;
        List list = coll;

        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(list.get(i))) return false;

        }

        return true;
    }

    @Override
    public int size() {
        System.out.println();
        return size;
    }

    public static void main(String[] args) {
        System.out.println("========================================");

        List list = new List();
        list.add("Samsung");
        list.add("Apple");
        list.add("Xiaomi");
        list.print();
        System.out.println(list.size());

        String[] array = {"Dell", "Asus"};
        list.addAll(array);
        list.print();
        System.out.println(list.size());

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("Acer");
        arrList.add("HP");
        arrList.add("Citizen");
        list.addAll(arrList);
        list.print();
        System.out.println(list.size());

        list.delete(0);
        list.print();
        System.out.println("Get: " + list.get(2));

        list.delete("Apple");
        list.print();

        System.out.println("Contains? " + list.contains("Asus"));

        list.clear();
        list.print();
        System.out.println("Size after clear: " + list.size());
        System.out.println("=================================");

        //  list.add(" ");
        list.add("Logitech");
        list.add("Rolex");
        //  list.add(" ");
        list.print();
        System.out.println(list.size());
        System.out.println(list.trim());
        list.print();
        System.out.println("После трима: " + list.size());
        System.out.println("=====================================");

        List list1 = new List();
        list1.add("lion");
        list1.add("Dog");
        list1.add("Cat");
        list1.add("Bird");

        List list3 = new List();
        list3.add("lion");
        list3.add("Dog");
        list3.add("Cat");
        list3.add("Bird");
        System.out.println(list3.compare(list1));

    }


}
