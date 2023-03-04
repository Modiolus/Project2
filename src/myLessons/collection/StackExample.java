package myLessons.collection;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("Zaur");
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Katya");
        System.out.println(stack);

        stack.pop(); // выводит верхний(последний) элемент коллекции и удаляет его
        System.out.println(stack);
        System.out.println(stack.peek()); // выводит верхний(последний) элемент коллекции НО НЕ удаляет его
        System.out.println(stack);

        System.out.println(stack.search("Oleg")); // выводит индекс исскомого объекта коллеции
    }
}
