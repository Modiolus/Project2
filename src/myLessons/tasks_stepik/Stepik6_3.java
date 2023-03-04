package myLessons.tasks_stepik;

import java.util.function.Function;
import java.util.function.Predicate;

public class Stepik6_3 {
    public static void main(String[] args) {
        U u = new U();
        T t = new T();
        int a = 10;
        int b = 15;
        System.out.println(a>=10? true: false);

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {


//        return  t->condition.test(ifTrue.apply(Object T));

return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
//        Predicate<Function<T, U>> p = condition ->ifTrue:ifFalse
//        return

//        return x-> condition.test(x)? ifTrue.apply(x) : ifFalse.apply(x); // your implementation here

    }

    static class U {

    }

    static class T {

    }

}
