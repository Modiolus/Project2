package hillel.clone;

public class CloneTest implements Cloneable {
    Integer i = 0;
    Pet pet;

    public CloneTest(Integer i) {
        this.i = i;
        this.pet = new Pet("Bobik", 10);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("run clone method");
        return super.clone();
    }
}
