package hillel.lesson4;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Введите первое число: ");
        double a = scan.nextDouble();

        System.out.println("Выберите действие: ");
        Scanner scan1 = new Scanner(System.in);
        String deystvie = scan1.nextLine();

        System.out.print("Введите второе число: ");
        double b = scan.nextDouble();

        if (b == 0) {
            System.out.println(" на 0 делить нельзя");

        }

        switch (deystvie) {
            case "*":
                System.out.println(multiplication(a, b));
                break;
            case "/":
                System.out.println(division(a, b));
                break;
            case "+":
                System.out.println(addition(a, b));
                break;
            case "-":
                System.out.println(subtraction(a, b));
                break;
            default:
                System.out.println("Неправильное действие");

        }
    }


    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

}
