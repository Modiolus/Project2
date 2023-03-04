package myLessons.collection.listInterface;

import java.util.ArrayList;
import java.util.List;

public class ArrEx {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("samsung");
        arrayList1.add("acer");
        arrayList1.add("asus");
        arrayList1.trimToSize();;

        arrayList1.add(3, "Dell");
        System.out.println(arrayList1);

        int PEOPLE_COUNT = 0;

        List<Person> people;


        {
            people = new ArrayList<>();
            people.add(new Person(++PEOPLE_COUNT, "Tom"));
            people.add(new Person(++PEOPLE_COUNT, "Bob"));
            people.add(new Person(++PEOPLE_COUNT, "Mike "));
            people.add(new Person(++PEOPLE_COUNT, "Katy"));

        }
        System.out.println(people);


//        ArrayList<String> arrayList2 = new ArrayList<>(arrayList1);
//
//        System.out.println(arrayList2);

    }
    static class Person{
        public int count;
        public String name;

        public Person(int count, String name) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
