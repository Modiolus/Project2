package myLessons.nestedClasses.innerStaticClass;

// внутренний класс static
public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }
//nested class т.е. вложенный
    static class Engine {
        int horsePower;

        public Engine(int powerHorse) {
            this.horsePower = powerHorse;
        }

       @Override
       public String toString() {
           return "Engine {" +
                   "horsePower=" + horsePower +
                   '}';
       }


   }

}
class Main{
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(150);

        System.out.println(engine);

        Car car = new Car("red", 4, engine);
        System.out.println(car);
    }

}


