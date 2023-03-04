package myLessons.lambda.supplier_consumer.Train;

import java.util.Scanner;
import java.util.function.Supplier;

public class App {


    public static void main(String[] args) {

        Supplier<User> userfactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userfactory.get();
        User user2 = userfactory.get();
        System.out.println(user1.getName());
        System.out.println(user2.getName());
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


