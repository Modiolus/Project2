package hillel.forHW10;

import java.util.ArrayList;
import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
//        ArrayList<String> states = new ArrayList<>();
//        states.add("Samsung");
//        states.add("Apple");
//        states.add("Acer");
//        states.add("Asus");
//        states.add("Dell");
//
//        Iterator<String> iterator = states.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.next())
        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");
        System.out.println(states);

        Iterator<String> iter = states.iterator();
       while(iter.hasNext()){
           // System.out.println(iter.hasNext());
            System.out.println(iter.next());
        }
//        System.out.println(iter.hasNext());
//        System.out.println(iter.next());
    }
}
