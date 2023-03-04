package myLessons.collection;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Palindrom {
    public static void main(String[] args) {
        String s = "madam2";
//        List<Character> list = new ArrayList<>();
        List<Character> list = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseIterator = list.listIterator(list.size());
        boolean isPalindrom = true;

        while (iterator.hasNext() && reverseIterator.hasPrevious()) {

            if (iterator.next() != reverseIterator.previous()) {
                isPalindrom = false;
                break;
            }
        }
        if (isPalindrom) {
            System.out.println("Palindrom");
        } else
            System.out.println("Not palindrom");

        System.out.println(list);
        System.out.println();
//===========================
//        Мое решение работает лучше(обходит знаки препинания и Заглавные буквы)
        // способ 1
        System.out.println("=====================================");
        System.out.println("My resolver");
        String p = "Madam, I'm Adam!!";
        p = p.replaceAll("[^A-Za-zА-Яа-я0-9]", "").toLowerCase(); // удаляет все знаки кроме букв и цифр, а затем переводим все к маленьким буквам
        String p2 = new StringBuilder(p).reverse().toString();
        boolean b = p.equals(p2);
        System.out.println("Palindrom? -->> " + b);
        // способ 2
        char[] array = p.toCharArray();

        boolean palindrom = true;
        for (int i = 0; i < (int) (Math.floor(array.length) / 2); i++) {
            for (int j = array.length - 1; j > (int) (Math.floor(array.length) / 2); j--) {

                if (array[i] == array[j]) {
                    palindrom = true;
                } else palindrom = false;
            }

        }
        System.out.println("Palindrom? -> " + palindrom);


        System.out.println("New method is palindrome? --> " + Palindrom.isPalindrome("Madam, I'm Adam!!"));

    }

    //    способ 3 - решение в одну строку!!
//    public static boolean isPalindrome(String text) {
//
//        return new StringBuilder(text.replaceAll("[^A-Za-zА-Яа-я0-9]", "")).reverse().toString()
//                .equalsIgnoreCase(text.replaceAll("[^A-Za-zА-Яа-я0-9]", ""));
//    }
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^A-Za-zА-Яа-я0-9]", "").toLowerCase();

        String p2 = new StringBuilder(text).reverse().toString();

        return text.equals(p2);
    }

}
