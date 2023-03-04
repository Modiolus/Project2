package hillel.lesson24;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapExample {
    public static void main(String[] args) {

        Map<St, Integer> map = new HashMap<>();
        St st1 = new St(5, 5);
        St st2 = new St(3, 2);

        System.out.println(st1.hashCode());
        map.put(st1, 10);
        map.put(st2, 15);
//        System.out.println(map.get(st1));
//        st1.a = 10;
//        System.out.println(st1.hashCode());
//        System.out.println(map.get(st1));

//        for (St s : map.keySet()) {
//            System.out.println(map.get(s));
//        }

        for (Map.Entry<St, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}

class St {
    int a;
    int b;

    public St(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        St st = (St) o;
        return a == st.a &&
                b == st.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "St{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
