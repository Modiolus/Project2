package hillel.lesson13.comp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComporatorExample {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Ivan"));
        userList.add(new User("Ivana"));
        userList.add(new User("Sveta"));
        userList.add(new User("Anna", "",34));
        userList.add(new User("Alex", "1",12));
        userList.add(new User("Alex", "2",43));
        userList.add(new User("Alex", "3",34));
        userList.add(new User("Petr", "",44));

        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };

        Comparator<User> ageComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };
        Comparator<User> lastNameComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        };

        userList.forEach(u -> System.out.println(u));
        System.out.println();
        userList.sort(userComparator.thenComparing(ageComparator));
        userList.forEach(u -> System.out.println(u));
        System.out.println();
        userList.sort(lastNameComparator.thenComparing(ageComparator));

        userList.forEach(u -> System.out.println(u));
    }
}


