package myLessons.lambda.lamdaREAD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AllLmd {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.forEach(st-> {
//            System.out.println(st);
//            st*=2;
//            System.out.println(st);
//        });

        ArrayList<String> al = new ArrayList<>();
        al.add("ivan");
        al.add("Petr");
        al.add("Vasiliy");
        al.add("Fedor");

        //System.out.println(al);

        al.forEach(System.out::println);

        Predicate<ArrayList<String>> predicate = s-> (s.contains("Vasiliy")&& s.size()<9);
        System.out.println("True?: "+predicate.test(al));

        Supplier<String> supplier = ()->
        //{
          //  al.remove(1);
            String.valueOf(al.add("Katya"));
           // return al.toString();
        //};
        System.out.println(al);
        System.out.println("=================================================");
        supplier.get();
        Consumer<ArrayList<String>> consumer = r-> System.out.println(r);
        consumer.accept(al);




    }
}
