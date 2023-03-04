package myLessons.generics;

public class ParametrizedClass2 {
    public static void main(String[] args) {

        Pair<String, String, Integer> pair1 = new Pair<String, String, Integer>("Ivan", "Ivanov", 32);
        System.out.println(pair1);
        String s = pair1.getValue1() + " " + pair1.getValue2() + "," + pair1.getValue3();
        System.out.println("Out String: "+s);

        OtherPair<String, Integer> otherPair = new OtherPair<>("Petr", 32);
        System.out.println(otherPair);
        System.out.println(otherPair.getValue1());

    }

}

class OtherPair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public OtherPair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "OtherPair {" +
                "value1 = " + value1 +
                ", value2 = " + value2 +
                '}';
    }
}

class Pair<V1, V2, V3> {

    private V1 value1;
    private V2 value2;
    private V3 value3;

    public Pair(V1 value1, V2 value2, V3 value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }

    public V3 getValue3() {
        return value3;
    }

    @Override
    public String toString() {
        return "Pair {" +
                "value1 = " + value1 +
                ", value2 = " + value2 +
                ", value3 = " + value3 +
                '}';
    }
}
