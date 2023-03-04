package hillel.collections;

public class Animal {

    public Animal() {

    }
    int id;
    public Animal(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    public void voice() {
        System.out.println("Bark");
    }
}
