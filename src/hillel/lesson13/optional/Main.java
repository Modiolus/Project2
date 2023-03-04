package hillel.lesson13.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        /*Optional оборачивает объект, тем самым нет прямого обращения через ссылку,
        * а значит в случае если обект null, то не будет выброшен nullPointerException
        * а распечатается то что мы пропишем в orElse*/
        Optional<String> hello = Optional.ofNullable("hello");
//        Optional<String> empty1 = Optional.of(null); // выбросит NullPointerException
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

//        String orElse = hello
//                .map(String::toUpperCase)
//                .orElse("world");
        /*вариант с лямбдой Supplier*/
//        String orElse = hello
//                .map(String::toUpperCase)
//                .orElseGet(() -> "world");
/*ниже лямбдой отработаны два условия ifPresent и OrElse*/
        hello.ifPresentOrElse(word ->
            System.out.println(word)
        , ()-> {
            System.out.println("world");

        });

     //   System.out.println(orElse);

    }
}
