package hillel.lesson13.optional.main2;

import java.util.Optional;
import java.util.function.Supplier;

public class Main2 {
    public static void main(String[] args) {

        Person p = new Person("Ivan", "ivan@mail.com");
        String email = (p.getEmail().orElse("У пользователя нет почты!")); // сработает когда email будет null
        System.out.println(email);

        /*вариант оборачивания в Optional целого объекта Person и тогда вызов происходит сначала get()
         т.е. достаем объект, а потом все что нужно, например, getEmail()*/
        Optional<Person> op = Optional.ofNullable(p);
//        op.ifPresent(Person::getName);
        String email1 = op.get().getEmail().orElse("У пользователя НЕТ ПОЧТЫ!");
        System.out.println(email1);

    }
}

class Person {
    private final String name;
    private final String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    /*оборачиваем в Optional парамаетр email, потому что мы не знаем будет ли у человека email, чтобы предотвратить nullPointerException */
    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
