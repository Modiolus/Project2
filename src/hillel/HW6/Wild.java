package hillel.HW6;

public class Wild extends Animal implements Voice, Predator {
    @Override
    public boolean isPredator() {
        return false;
    }

    @Override
    public void sayHello() {
        System.out.print("Hello i am a wild animal");
        if (isPredator()) {
            System.out.println(" and i am angry");
        }
    }

}
