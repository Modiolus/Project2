package hillel.clon2;

public class PersonMain {
    public static void main(String[] args) throws CloneNotSupportedException {

      //  Car car = new Car("Green");

        Person person = new Person("Mike", 25);

        Person clone = (Person) person.clone();
       // Person
        clone = person;

        System.out.println(person.name + ", " + person.age + " link: " + person);
        System.out.println(person);
        System.out.println(clone.name + ", " + clone.age + " link: " + clone);
        System.out.println(clone);




    }
}
