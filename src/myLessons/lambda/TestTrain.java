package myLessons.lambda;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class TestTrain {
    //    static int met(InterfaceFunctional interfaceFunctional) {
//        return interfaceFunctional.methodFromInt(3, 4);
//    }
//
//    public static void main(String[] args) {
////        InterfaceFunctional interfaceFunctional = new InterfaceFunctional() {
////            @Override
////            public int methodFromInt(int a, int b) {
////                return a + b;
////            }
////        };
//
//        InterfaceFunctional i = Integer::sum;
//        int res = i.methodFromInt(3, 6);
//        System.out.println(res);
//
//        met((a, b) -> a + b);
//
//    }
    public static void main(String[] args) {
        I i = s -> s.length();
        I i1 = String::length; // второй способ
        System.out.println(i.abc("Privet"));

    }
}

interface I {
    int abc(String s);
}

//interface InterfaceFunctional {
//    int methodFromInt(int a, int b);
//}

