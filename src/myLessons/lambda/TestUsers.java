package myLessons.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestUsers {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("Ivan");
        ls.add("Petr");
        ls.add("Maxim");
        ls.add("Aleksandr");
        ls.forEach(System.out::println);

        System.out.println(ls);
    }
}
