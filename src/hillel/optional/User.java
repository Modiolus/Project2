package hillel.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class User {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        // System.out.println(name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User print() {
        System.out.println("test massage");
        return new User();
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        User user = new User();

        User user1 = null;
        user.setAge(30);
        user.setName("Ivan");
        System.out.println("user -- "+user);
        System.out.println(user.getAge());

        Optional<User> optionalUser = Optional.of(user);
        System.out.println("1" + Objects.nonNull(user));

        optionalUser.ifPresent(User::getName);

        if (optionalUser.isPresent()) {
            System.out.println("2" + optionalUser.get().getName());
        }
        User opt = Optional.ofNullable(user1).orElse(new User());
        User opt1 = Optional.ofNullable(user).orElseGet(User::print);//справа ссылка на мотод класса User
        User opt2 = Optional.ofNullable(user).orElseThrow(() -> new RuntimeException());

        User u1 = Optional.ofNullable(user).map(u -> {
            user.setAge(15);
            user.setName("Ales");

            return u;
        }).get();
        System.out.println(u1);

        User u2 = Optional.of(u1).filter(i -> i.getAge() > 18).orElse(new User());
    }


}
