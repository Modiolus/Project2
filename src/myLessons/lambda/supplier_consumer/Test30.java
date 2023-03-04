package myLessons.lambda.supplier_consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test30 {
    /*в интерфейсе Supplier<T> в парамаетры принимает объект Т. Метод T get() возвращающий объект T
     *Supplier переводится как поставщик */
    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> a1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            a1.add(carSupplier.get());
        }
        return a1;
    }

    public static void changeCar(Car car, Consumer<Car> cons) {
        cons.accept(car);

    }

    public static void main(String[] args) {

        ArrayList<Car> cars = createThreeCars(() -> new Car("Nissan", "red", 1.6));

        System.out.println("Supplier:\n" + cars);

//        Consumer<Car> c = new Consumer<Car>() {
//            @Override
//            public void accept(Car car) {
//
//            }
//        };
        Consumer<Car> c = new Consumer<Car>() {

            @Override
            public void accept(Car car) {
                car.color="jdjd";
                car.engine =3;


                System.out.println("Мой метод-->> "+car);
            }
        };
       c.accept(cars.get(0));

        changeCar(cars.get(0)
                , car -> {
                    car.color = "white";
                    car.engine = 2.4;
                    System.out.println("Consumer: \n" + car);
                });
        /*интерфейс Consumer<T> в параметры принимает объект Т. Метод пустой void accept(T t) принимает объект Т. Т.к. пустой то будет реализация System.out.println*/
//        Consumer<ArrayList<Car>> carConsumer = cars1 -> System.out.println("TTEE: " + cars1);
//        carConsumer.accept(cars);
        System.out.println("Test");
        Consumer<ArrayList<Car>> carConsumer1 = System.out::println;

        carConsumer1.accept(cars);

    }
}

class Car {
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car {" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
