package myLessons.collection.mapIntrface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapEx {
    int salary;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapEx hashMapEx = (HashMapEx) o;
        return salary == hashMapEx.salary && Objects.equals(name, hashMapEx.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, name);
    }

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();

        map1.put(1000, "Zaur Tregulov");
        map1.put(4532, "Ivan Ivanov");
        map1.put(4321, "Mariya Sidorova");
        map1.put(1232, "Nikolay Petrov");
        map1.put(5632, "Nikolay Petrov");
        System.out.println(map1);


        map1.putIfAbsent(1000, "Oleg Maksimov"); // добавляет, если такой объект отсутствует
        System.out.println(map1);

        System.out.println(map1.get(1000));
        map1.remove(4321);// удаляет объект по ключу
        System.out.println(map1);
        System.out.println(map1.containsValue("Ivan Ivanov"));
        System.out.println(map1.containsKey(5632));
        System.out.println(map1.keySet()); // выводит множество всех ключей
        System.out.println(map1.values()); // выводит множество значений
        System.out.println("Test: " + map1.entrySet());

        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
