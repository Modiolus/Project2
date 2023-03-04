package myLessons.patterns.builder;

import lombok.Builder;
import lombok.Singular;

//@Builder
// реализация через библиотеку lombok. Достаточно: поля в классе и переопределения toString
// но тогда в мэйне можно создать объект класса Car и в конструкторе прописать все поля. А это уже не совсем правильно
// ведь основная идея паттерна это создание неизменяемого класса и засечивание тех параметров кторые нужны, а не всех!
// НО ЭТО МОИ ВЫВОДЫ... ХОТЯ РЕАЛИЗАЦИЯ ЧЕРЕЗ lombok ВОЗМОЖНА...

public class Car {
    private String engine;
    private String model;
    private int countDoor;
    private int passengers;
    private static int countCar = 0; // !!!переменная просто для подсчета созданных обектов в билдере. К самому паттерну не имеет отношения. Просто для красоты аутпута

    private Car(CarBuilder carBuilder) { // на вход принимает объект CarBuilder со всеми его значениями
        this.engine = carBuilder.engine;
        this.model = carBuilder.model;
        this.countDoor = carBuilder.countDoor;
        this.passengers = carBuilder.passengers;
    }
//     public Car(){
//
//     }

    @Override
    public String toString() {
        return "Car" + ++countCar + " {" + // переменная просто для подсчета созданных обектов в билдере.
                "engine='" + engine + '\'' +
                ", model='" + model + '\'' +
                ", countDoor=" + countDoor +
                ", passengers=" + passengers +
                '}';
    }

    public static class CarBuilder {
        private String engine;
        private String model;
        private int countDoor;
        private int passengers;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;

        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setCountDoor(int countDoor) {
            this.countDoor = countDoor;
            return this; //теукщая ссылка на инстанс CarBuilder в памяти
        }

        public CarBuilder setPassengers(int passengers) {
            this.passengers = passengers;
            return this;
        }

        public Car build() {
            return new Car(this);
            // возварщает новый экземпляр Car и в скобках ссылку на CarBuilder(и соотв на его значения)
        }
    }

}

