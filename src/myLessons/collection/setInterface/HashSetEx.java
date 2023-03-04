package myLessons.collection.setInterface;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zaur"); // метод add содержит в себе метод put от hashMap
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");

        set.remove("Zaur");

        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Misha"));
        System.out.println(set.contains("Marina"));
    }
}
