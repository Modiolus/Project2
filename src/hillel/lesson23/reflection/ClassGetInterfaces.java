package hillel.lesson23.reflection;
import hillel.lesson23.reflection.ex.Clazz2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ClassGetInterfaces {
    public static void main(String[] args) {
        Class<?> cls = ArrayList.class;
        Class<?>[] ifs = cls.getInterfaces();

        System.out.println("ArrayList of interfaces\n");
        for (Class<?> ifc : ifs) {
            System.out.println(ifc.getName());
        }
        System.out.println("+++++++++++++++++++++++++++++++++");

        cls = LinkedList.class;
        ifs = cls.getInterfaces();
        System.out.println();
        System.out.println("LinkedList of interfaces\n");
        for (Class<?> ifc : ifs) {
            System.out.println(ifc.getName());
        }

        cls = Clazz2.class;
        ifs = cls.getInterfaces();
        System.out.println();
        System.out.println("Clazz2 of interfaces\n");
        for (Class<?> ifc : ifs) {
            System.out.println(ifc.getName());
        }



    }
}
