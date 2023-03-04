package hillel.Trainee;

public class TestBar {
    public static void main(String[] args) {
        //     bar();
        //    foo();

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 == s3? " + (s1 == s3));
        System.out.println("s1 equals s3? " + (s1.equals(s3) ));
    }



//    public static void bar(){
//        int[] nums = {1, 2, 3};
//        for (int x = 0; x < nums.length ; x++) {
//            System.out.println("Do: "+x);
//            System.out.println("nums[x]: " + nums[x]);
//            x += nums[x];
//
//        }
//        System.out.println(x);
//    }
//  static void foo(){
//        String m = "Hello";
//        System.out.println(m);
//        bar(m);
//        System.out.println(m);
//    }
//   static void bar(String m){
//        m +=" World!";
//    }

}
