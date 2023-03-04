package myLessons.lambda.supplier_consumer.Train;

public class Trainee {
    public static void main(String[] args) {

        Interfs i = a -> a<7;
       boolean boo = i.methodTest(3);
        System.out.println(boo);
    }
}
interface Interfs {
    boolean methodTest(int a);
}
