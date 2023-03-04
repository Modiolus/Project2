package hillel.arrayToList;

import java.util.*;
import java.util.function.Consumer;

public class StringArrayList implements Iterator {
    private String[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public StringArrayList() {
        this.elements = new String[DEFAULT_CAPACITY];
    }

//    public StringArrayList(String[] elements) {
//        this.elements = elements;
//    }


//    public StringArrayList(int initialCapacity) {
//        if (initialCapacity >= 0) {
//            this.elements = new String[initialCapacity];
//        } else {
//            throw new IllegalStateException("Capacity can`t be less then 0!");
//        }
//
//    }

    public String get(int index) {
        isIndexExist(index);
        return elements[index];

    }

    public int size() {
        return size;
    }

    public boolean add(String value) {

        if (size == elements.length) {
            elements = increaseCapacity();
     //   System.out.println("SIZE--> "+ size+" -elements.length-->"+elements.length + " -value-->"+value); // просто проверка
        }
        elements[size] = value;
        size++;
        return true;
    }

    public boolean add(String value, int index) {
        isIndexExist(index);
        String[] temp = elements;
        elements = new String[temp.length + 1];

        elements[index] = value;
        System.arraycopy(temp, 0, elements, 0, index);// копирует перв часть до индекса нового еэлемента
        System.arraycopy(temp, index, elements, index + 1, temp.length - index);// копирует втор часть после индекса нового элмента и количесвтвом минус перв часть
        size++;
        return true;

    }

    @Override
    public String toString() {
        String[] temp = new String[size];
        System.arraycopy(elements, 0, temp, 0, size);
        return Arrays.toString(temp);
    }


    public boolean delete(int index) {
        isIndexExist(index);
        String[] temp = elements;
        elements = new String[temp.length - 1];
        String value = temp[index];

        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);

        size--;
        return true;
    }

    public boolean delete(String value) {
        int index = 0;
        String[] temp = elements;
        elements = new String[temp.length - 1];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == value) {
                index = i;
                String buf = value;
            }
        }
        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);

        size--;
        return true;

    }

    private String[] increaseCapacity() {
        String[] temp = new String[(elements.length * 2)];
        System.arraycopy(elements, 0, temp, 0, elements.length);

        return temp;
    }

    private int isIndexExist(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Element can`t be found! " + "Number of elements in array = " + size +
                    ". Total size of array = " + elements.length);

        }
        return index;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {
    }
    @Override
    public boolean hasNext() {
//        for (int i = 0; i < elements.length; i++)
//            return i != size;
//
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {  //elements[i] != null
                return true;
            }
        }
        return false;
    }
    @Override
    public Object next() {

//        for (int i = 0; i < elements.length; i++) {
//            if (i >= size) {
//                throw new NoSuchElementException();
//            } else elements = new String[elements.length];
//            if (i >= elements.length) {
//                throw new ConcurrentModificationException();
//            } else
//                i++;
//
//        }
//        if (!hasNext()){
//            throw new NoSuchElementException();
//        }
        String next;
        for (int i = 0; i < elements.length; i++) {
            if (hasNext()) { //i< elements.length
                next = elements[i];
            }
            else //i> elements.length
                throw new NoSuchElementException();
                   }
//        if (hasNext()){
//            return  elements;
//        }
        return null;
    }
    //        String[] temp = elements;
//        int i;
    //        elements = new String[elements.length];
//        for (int i = 0; i < elements.length; i++) {
//            if (i < elements.length) {
//                 return elements[i];
//               // System.out.println(elements[i]);
//                // System.arraycopy(temp, 0, elements, 0, 1);
//                // return elements[i];
//            }
//            else System.out.println("NoSuchElementException");
//        }
//        return null;
//    }
    public static void main(String[] args) {
        StringArrayList str = new StringArrayList();
        System.out.println("Add value: ");
        str.add("Samsung");
        str.add("Apple");
        str.add("Philips");
        str.add("Acer");
        str.add("Asus");
        str.add("Dell");
        str.add("Xiaomi");
        str.add("HP");
        str.add("Lenovo");
        str.add("Seiko");
        str.add("Huawey");
        str.add("iPhone");
        System.out.println("Add value: " + str);
//        System.out.println("hasNext " + str.hasNext());
//         System.out.println("NEXT " + str.next());
        System.out.println("==========================");
//        while (str.hasNext()) {
//            System.out.println(str.next());
//        }

        System.out.println("=======================================");

        System.out.println("Add value and index: ");

        str.add("Test", 0);
//        str.add("Test", 1);
//        str.add("Test", 2);
//        str.add("Test", 3);
//        str.add("Test", 4);
//        str.add("Test", 5);
//        str.add("Test", 6);
//        str.add("Test", 7);
//        str.add("Test", 8);
//        str.add("Test", 9);
//        str.add("Test", 10);
//        str.add("Test", 11);
        System.out.println(str);
        System.out.println("Delete of value: ");
        str.delete("Apple");
        System.out.println(str);
        System.out.println("Delete of value on index: ");
        str.delete(4);
        System.out.println(str);

        System.out.println("Getting element of 6 index: " + str.get(6));
        System.out.println("Size of array: " + str.size());

    }


}
