package hillel.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrCollection {
    public static void main(String[] args) {

        ArrayList<String> brands = new ArrayList<>();
       // String[] test = new String[10];
      //  Arrays.copyOf(test, test.length);

        brands.add("Samsung");
        brands.add("Huaway");
        brands.add("Xiaomi");
        brands.add("Philips");
        brands.add("Intelite");
        brands.add("Canon");
        brands.add(1, "test");
        System.out.println("Original list " + brands);

        System.out.println();

        System.out.println(brands.get(4));
//
//        brands.remove(3);
//        System.out.println(brands);

//        List<Animal> listOfAnimal = new ArrayList<>();
//        listOfAnimal.add(new Animal(1));
//        method(listOfAnimal);
//
//        List<Dog> listOfDogs = new ArrayList<>();
//        listOfDogs.add(new Dog());
//
//        method(listOfDogs);
//
//    }
//
//    static void method(List<? extends Animal> list) {
//        for (Animal animal : list) {
//            animal.voice();
//        }
//
    }
}
