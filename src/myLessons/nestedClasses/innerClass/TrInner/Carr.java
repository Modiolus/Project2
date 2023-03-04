package myLessons.nestedClasses.innerClass.TrInner;

public class Carr {
    String color;
    int doorCount;
    Enginee engine;

    public Carr(String color, int doorCount) {  //, int horsePower
        this.color = color;
        this.doorCount = doorCount;
        //this.engine = this.new Enginee(horsePower);
    }

    public void setEngine(Enginee engine) {
        this.engine = engine;

    }

    @Override
    public String toString() {
        return "Carr{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    //============ inner =============
    public class Enginee {
        private int horsePower;
        public final static int a = 0;

        public Enginee(int horsePower) {
            this.horsePower = horsePower;

        }

        @Override
        public String toString() {
            return "Enginee{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class CarrMain {
    public static void main(String[] args) {
        Carr carr = new Carr("white", 3);
        Carr.Enginee enginee = carr.new Enginee(120);

        carr.setEngine(enginee);

        System.out.println(carr);
        System.out.println(enginee);


    }
}
