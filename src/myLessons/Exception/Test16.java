package myLessons.Exception;

public class Test16 {
    /*пример, чтобы показать ClassCastException*/
//    public static void main(String[] args) {
//
//        createPwd("ytr");
//    }
//
//    /*пример, чтобы показать IllegalArgumentException
//    используется когда аргумент попадает под условие*/
//    public static void createPwd(String pwd) {
//        if (pwd.length() < 6) {
//            throw new IllegalArgumentException("Dlina parolia slishkom malenkaya");
//        }
//        if (pwd.length() > 12) {
//            throw new IllegalArgumentException("Dlina parolia slishkom bolshaya");
//        }
//        System.out.println("Parol prinyat");
//    }
    //        Doctor d = new Doctor();
//        Teacher t = new Teacher();
//
//        Employee[] array1 = {d, t};
//        Teacher t2 = (Teacher)array1[0]; // не можем кастить через (Teacher) т.к. на 0 индексе находится Doctor


}
//class Employee {
//
//}
//
//class Doctor extends Employee {
//}
//
//class Teacher extends Employee {
//}
//================================================
/*приммер с IllegalStateException*/
class Samolet {
    String sostoyanie = "v ojidanii";

    public void letet() {
        sostoyanie = "v vozduxe";
        System.out.println("Samolet letit");
    }

    public void ojidat() {
        if (sostoyanie.equals("v vozduxe")) {
            throw new IllegalStateException("Samolet uje v vozduxe");
        }
        sostoyanie = "v ojidanii";
        System.out.println("Samolet v ojidanii poleta");
    }
    public void otmnitPolet() {
        if (sostoyanie.equals("v vozduxe")) {
            throw new IllegalStateException("Samolet uje v vozduxe");
        }
        sostoyanie = "polet otmenen";
        System.out.println("Polet samoleta otmenen");
    }

    public static void main(String[] args) {
        Samolet s = new Samolet();
        s.ojidat();
        s.letet();
        s.otmnitPolet();

    }
}


