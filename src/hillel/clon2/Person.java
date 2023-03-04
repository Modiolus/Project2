package hillel.clon2;

public class Person implements Cloneable {
    String name;
    int age;
  //  Car car;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
       // this.car = car;
        //  car = new Car(car.color);
        System.out.println("Name " + name+ ", age " + age);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

//class Car {
//    String color;
//
//    Car(String color) {
//        this.color = color;
//    }
//}
