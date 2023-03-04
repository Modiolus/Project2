package hillel.lesson4;

public class MainStudent {
    public static void main(String[] args) {

        Student st1 = new Student("Imya", "Familia");
        System.out.println(st1.toString());

/*почему такой вывод в строки, ведь даже если убрать toString() то вывод остаётся такой же
*что такое ?? @Override
    public int hashCode()*/

        Student st2 = new Student("FN", "LN");
        st2.setAge(12);
        st2.setPhone("12345678765");
      //  System.out.println(st2.toString());
        System.out.println(st2);

        Student st3 = new Student("FN", "LN", 23, "3806767676767");
       // System.out.println(st3.toString());


    }
}
