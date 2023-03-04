package myLessons.tasks_stepik;

public class Stepic2_22 {
//    public static boolean isPowerOfTwo(int value) {
//        return Integer.toBinaryString(Math.abs(value)).replace("0", "").length() == 1;
//    }
    public static boolean isPowerOfTwo(int value) {

        return Integer.bitCount(Math.abs(value)) == 1;
    }



    public static void main(String[] args) {
        System.out.println(Stepic2_22.isPowerOfTwo(8));



    }
}
