package myLessons.lambda.predicate;

import javax.xml.transform.sax.SAXResult;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIf {

    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Privet");
        a1.add("Poka");
        a1.add("Ok");
        a1.add("Uchim java");
        a1.add("A imenno lambdas");

         a1.removeIf(element -> element.length() < 5);

        /*второй вариант написания*/
//        Predicate<String> p = element -> element.length() < 5;
//        a1.removeIf(p);
//        System.out.println(a1);
        //====================================
        Predicate<String> p = element -> element.length() < 5;
        Predicate<String> p1 = element -> element.length() > 3;

//        Predicate<String> predicate;

//         out(a1, p);
    }
    public static void out(ArrayList<String> arrayList, Predicate<String> pre) {
        for (String s : arrayList) {
            if (pre.test(s)) {
                System.out.println(s);
            }
        }

    }

}
