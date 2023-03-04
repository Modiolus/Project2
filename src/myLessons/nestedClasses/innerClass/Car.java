package myLessons.nestedClasses.innerClass;

// внутренний класс НЕ static
public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, int powerHorse) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(powerHorse);

    }

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    //======= второй способ ==========
    // powerHorse добавляется в мэйне
    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;

    }

    @Override
    public String toString() {
        return "Car {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // inner class т.е. внутренний
    class Engine {
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

class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Black", 2, 200);
        Car car2 = new Car("White", 4);
        Car.Engine engine = car2.new Engine(150);// для конструктора с двумя параметрами
        //Car.Engine - путь к классу Engine. Обращение к объекту Engine - car2.new Engine(), Как к полю.
        // т.к. объект new Engine принадлежит экземляру класса Car и мы може братиться к нему через ссылку car2

        System.out.println(engine);
        car2.setEngine(engine); // сетит значение engine в классе Car для конструктора с двумя параметрами

        System.out.println(car1);
        System.out.println(car2);

    }
}


