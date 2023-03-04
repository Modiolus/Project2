package hillel.forHW10;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Task2<Types> {

    String[] array;
    //String array;
    int capacity;
    int index;

    public Task2(String[] array, int capacity) {  //String[] array,
        this.array = array;
        //  Type[] array = new Type[] newArray;
        this.capacity = capacity;
    }
    public Task2(int capacity) {
        this.array = new String[capacity];
        this.capacity = capacity;
    }
    public boolean hasNext() {
        // array = new String[capacity];

          for (int index = 0; index < capacity-1; index++) {
              // System.out.println(array[i]);
              if (index < capacity) {
                  System.out.println(index);
                  return true;
              }
          }
        return false;
    }
    public boolean next() {

        while (hasNext() == true) {
            array[index] = array[index++];
            System.out.println(array[index]);
        }
        return true;
    }
    public void remove() {
    }
    public void forEachRemaining(Consumer action) {
    }
    boolean add () {
        return true;
    }
    public static void main(String[] args) {
        String[] brands = new String[]{"Samsung", "Apple", "Acer", "Asus", "Dell"};
        Task2 task2 = new Task2(brands, 5);

        Task2 task3 = new Task2(5);


       // for (int index = 0; index < task2.capacity; index++) {
            while (task2.hasNext()) {
                System.out.println(task2.next());
            }
    }
}

