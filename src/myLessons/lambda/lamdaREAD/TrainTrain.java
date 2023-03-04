package myLessons.lambda.lamdaREAD;


import java.util.*;
import java.util.function.Predicate;

public class TrainTrain {
    /* лямбда это переопределение метода анонимного класса, который имплементирует функциональный интерфейс*/
    public static void main(String[] args) {
//        Dew dew = new Dew() {
//            @Override
//            public double sqrt(double b) {
//              return Math.sqrt(b);
//
//            }
//        };
//        dew.sqrt(4);
//классика изображения анонимного класса
        Sum s = new Sum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        System.out.println(s.sum(4, 7));
/*слева от равно пишем функциональную ссылку анонимного класса которая имплементирует функц интерфейс
* а так как этого класса как бы нет, то тип будет как название интерфейса*/
        Sum s1 = (a, b) -> a + b; //реализация метода
        Sum s2 = Integer::sum; // второй способ реализации метода
        System.out.println(s2.sum(3, 7)); // вызов и вывод метода

        Dew dew = x -> Math.sqrt(x);//реализация метода. sqrt - статический метод стандартного класса Math
        Dew dew1 = Math::sqrt; // второй способ реализации метода

        System.out.println(dew1.sqrt(4)); // вызов и вывод метода соданного в нашем классе Dew ниже

        Void v = str -> System.out.println(str); // реализация метода
        Void v1 = System.out::println;    // второй способ реализации метода
        v1.ex("Hello");

        /* метод forEach является статическим методом коллекций и Map
        * внутри метола используется Consumer c методом void accept(T t)*/
        Map<String, String> map = new HashMap<>();
        map.put("Ivan", "Ivanov");
        map.put("Petr", "Petrov");
        map.put("Sidr", "Sidorov");
        System.out.println("Foreach");
        map.forEach((a, b) -> System.out.println(a + ":" + b));

        ArrayList<String> arr = new ArrayList<>();
        arr.forEach(a -> System.out.println(a));
        arr.forEach(System.out::println);  // второй способ реализации метода
        List<String> ls = new ArrayList<>();

    }
}

interface Dew {
    double sqrt(double x);

}

interface Sum {
    int sum(int a, int b);
}

interface Void {
    void ex(String s);

}

