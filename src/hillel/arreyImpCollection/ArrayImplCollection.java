package hillel.arreyImpCollection;

import java.util.*;

public class ArrayImplCollection{
    String[] array = {"Samsung", "Apple", "Logitech", "Acer", "Asus"};



    public static void main(String[] args) {
      //  String[] array = {"Samsung", "Apple", "Logitech", "Acer", "Asus"};

        List<String> brands = new ArrayList<>();
      //  Collections.addAll(brands, array);
//        brands = Arrays.asList(array);
        brands.add(3, "Dell");
        brands.add("Philips");
        System.out.println(brands);
        brands.remove("Acer");

        System.out.println(brands);

        System.out.println(brands.get(2));
        boolean b = brands.contains("Logitech");
        System.out.println(b);
        System.out.println(brands.size());

        boolean b1 = brands.equals("Apple");
        System.out.println(b1);

        brands.clear();
        System.out.println(brands);


    }
}
