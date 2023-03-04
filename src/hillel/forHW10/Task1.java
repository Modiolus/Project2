package hillel.forHW10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task1 {


    public Set<String> ArrayToString(ArrayList<String> list) {
        Set<String> set = new HashSet<String>(list);
        System.out.println("Without duplicates: " + set);
        return set;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("2");
        list.add("3");
        list.add("1");
        System.out.println("Original: " + list);
        Task1 task1 = new Task1();

        task1.ArrayToString(list);
    }
}
