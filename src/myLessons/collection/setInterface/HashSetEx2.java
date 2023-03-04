package myLessons.collection.setInterface;

import java.util.HashSet;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(5);
        hashSet2.add(8);

        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);// происходит объединение 2-х hashSet-ов и результирующий НЕ будет иметь дубликаты
        System.out.println(union);

        HashSet<Integer> interSect = new HashSet<>(hashSet1);
        interSect.retainAll(hashSet2);// оставит только те элементы которые пересекаются т.е. одинаковые
        System.out.println(interSect);

        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2);// отнимет из hashSet1 все элементы hashSet2 и оставит только те элементы которых нет во втором hashSet-е
        System.out.println(subtract);
    }
}
