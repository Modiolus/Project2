package myLessons.optional;

import java.util.Optional;

class Main {
    public static void main(String[] args) {
        Optional<String> hello1 = Optional.of("Hello");
        Optional<String> hello2 = Optional.ofNullable(null);
        /* .of не умеет работать с null и в случае null в параметрах будет выброшен nullPointerException
         * .ofNullable если нет объекта возвращает null, если есть объект то возвращает сам объект*/

        System.out.println(hello1.isPresent());
        System.out.println(hello1.isEmpty());
        String orElse = hello2.orElse("World"); // если hello2 null, то верни "World"

        System.out.println(hello2);
        System.out.println("orElse-> " + orElse);
        String orElse2 = hello2
                .map(String::toUpperCase)
                .orElse("Test");
        hello1.ifPresent(word -> System.out.println(word));// если не null, то выведи значение
        hello2.ifPresentOrElse(word -> {
                    System.out.println(word);
                },
                () -> System.out.println("World"));// здесь после запятой - выражение OrElse

        System.out.println(orElse2);

        System.out.println("=====================================================================");
        //============================================================================================
        Person person = new Person("Sergey", null);

        String email = person
                .getEmail()
                .map(String::toUpperCase)
                .orElse("Sergey doesn't have email");

        System.out.println(email);

// второй способ менее лаконичный
        if (person.getEmail().isPresent()) {
            String email1 = person.getEmail().get();
            System.out.println(email1.toUpperCase());
        } else System.out.println("Sergey doesn't have email");

    }
}

public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {  // оборачиваем в Optional<String> чтобы в случае отсутствия email не было выброшено NPE
        return Optional.ofNullable(email);// также прописываем метод ofNullable
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


