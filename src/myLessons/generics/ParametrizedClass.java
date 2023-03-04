package myLessons.generics;

public class ParametrizedClass {
    public static void main(String[] args) {

        Info<String> info1 = new Info<>("Ivanov");

        System.out.println(info1.getValue());
        System.out.println(info1);

        Info<Integer> info2 = new Info<>(23);
        System.out.println(info2.getValue());
        System.out.println(info2);

        Info<Bus> busInfo = new Info<>(new Bus());
        Bus b = busInfo.getValue();
        b.setB("Volvo");
        System.out.println(b.getB());

        ParExample<Double> parExample = new ParExample<>(3.14);
        System.out.println(parExample);

    }
    //  "===================================="
    //"Type erasure" JVM считает эти два метода одинаковыми т.к. убирает <String>. Отдельно сработет любой один метод
    // для JVM оба эти метода выглядят так:  abc(Info info1)
    // это также справедливо если класс потомок будет содержать один из ниже методов и будет наследовать второй метод от
    // родителя. Т.е. снова будет "Type erasure". Подчеркнёт красным.
//    public void abc(Info<String> info){
//        String str = info.getValue();
//    }
//    public void abc(Info<Integer> info){
//        Integer i = info.getValue();
//    }
// "============================================="
}

class Info<T> {  //<T> в дальнейшем под Т можно подставить любой обёрточный тип(String, Integer, Double и т.д.)

    private T value;

    public Info(T value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Info {" +
                "value = " + value +
                '}';
    }

    public T getValue() {
        return value;
    }
}

class ParExample<P extends Number> { // в <> можно писать наследование от высешего класса, тогда можно в параметрах указать
    //все,что есть под этим родителем, пример в main методе ParExample<Double> parExample = new ParExample<>(3.14);
    private P val;

    public ParExample(P val) {
        this.val = val;
    }

    public P getVal() {
        return val;
    }

    public void setVal(P val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ParExample{" +
                "val = " + val +
                '}';
    }
}

class Bus {
    private String str;
    private String b;


    public String getB() {
        return b;
    }

    public void setB(String b) {
        // b = str;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "b=" + b +
                '}';
    }
}
