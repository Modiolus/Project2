package myLessons.generics.Train;

public class GenTest {
    public static void main(String[] args) {
        Clazz<String> c = new Clazz<>("Ivan");
        String s = c.testMethod("Petr");
        System.out.println(c);
        System.out.println(s);

        int a = c.testMethod(12);

        System.out.println("a--> "+a);

    }
}

class Clazz<V> {
  final private V value;

    public Clazz(V value) {
        this.value = value;
    }

    public <T>T testMethod(T val) {
        return val;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "value=" + value +
                '}';
    }
}