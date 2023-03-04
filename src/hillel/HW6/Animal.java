package hillel.HW6;

public abstract class Animal {
    private int id;
    private byte age;
    private double weight;
    String name;
    private String color;

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", age=" + age +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
