package hillel.clone;

public class CloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest ct = new CloneTest(12);

        CloneTest c = (CloneTest) ct.clone();
        //CloneTest c1 = ct;


       // System.out.println(ct.i);
       // System.out.println(c1.i);
        System.out.println(c.i);

        System.out.println(ct);
       // System.out.println(c1);
        System.out.println(c);

        System.out.println("=======================");



//        c1.i = 13;
//
//        System.out.println(ct.i);
//        System.out.println(c1.i);
//        System.out.println(c.i);
//
//        System.out.println(ct.pet);
//        System.out.println(c1.pet);
//        System.out.println(c.pet);
    }
}
