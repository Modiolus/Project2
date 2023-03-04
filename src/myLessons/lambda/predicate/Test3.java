package myLessons.lambda.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {

        Empl e1 = new Empl("Ivan", 1500);
        Empl e2 = new Empl("Petr", 800);
        ArrayList<Empl> are = new ArrayList<>();
        are.add(e1);
        are.add(e2);
        Predicate<Empl> p1 = new Predicate<Empl>() {
            @Override
            public boolean test(Empl empl) {
                if (empl.salary > 1000) {
                    return true;
                }
                return false;
            }
        };

        /*в интерфейсе Predicate<T> метод boolean test(T t) возвращающий true или false, его удобно использовать когла нужно например сравнивать по какому то критерию*/
        Predicate<Empl> p = empl -> empl.salary > 1000;
// строкой выше мы переопределили метод и частично его реализовали(> 1000)
// по другому мы могли бы создать класс который имплементит предикат и абстрактно реализует метод и затем сделать бОлшую реализацию сторкой выше

        for (Empl e : are) {
            if (p.test(e)) {
//            if (p.test(e)) {
                System.out.println(e);
            }
        }
        Supplier<Empl> em = new Supplier<Empl>() {
            @Override
            public Empl get() {
                return null;
            }
        };
        /*в интерфейсе Supplier<T> в парамаетры принимает объект Т. Метод T get() возваращающий объект T
         *Supplier переводится как поставщик */
        Supplier<Empl> s = () -> new Empl("Anna", 200);
        are.add(s.get());
        boolean b = are.contains(s.get()); // разобраться почему выводит false

        System.out.println(are);
        System.out.println(b);

//    Supplier<Empl> s = new Supplier<Empl>() {
//        @Override
//        public Empl get() {
//            return null;
//        }
//    };
    }


}

class Empl {
    String name;
    Integer salary;

    public Empl(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Empl {" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
