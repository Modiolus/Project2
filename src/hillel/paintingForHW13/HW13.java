package hillel.paintingForHW13;

import java.util.Scanner;

public class HW13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число ");

        String numb = scan.nextLine();
        char c = numb.charAt(0);

        char[] picture = numb.toCharArray();
        //pictureNumbers(picture);

        if (Character.isDigit(c)) {

            pictureNumbers(picture);

        } else System.out.println("Вы ввели не число!");

    }

    public static void pictureNumbers(char[] numbers) {
        String[][] drawNumber = {{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        for (int i = 0; i < numbers.length; i++) {
            String[][] temp = select(numbers[i]);
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp[i].length; k++) {
                    drawNumber[j][k] += temp[j][k];
                }

            }
        }

        for (int i = 0; i < drawNumber.length; i++) {
            for (int j = 0; j < drawNumber[i].length; j++) {
                System.out.print(drawNumber[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] select(char s) {
        switch (s) {
            case '0':
                return pictureZero();
            case '1':
                return pictureOne();
            case '2':
                return pictureTwo();
            case '3':
                return pictureThree();
            case '4':
                return pictureFour();
            case '5':
                return pictureFive();
            case '6':
                return pictureSix();
            case '7':
                return pictureSeven();
            case '8':
                return pictureEight();
            case '9':
                return pictureNine();

        }
        return null;
    }

    private static String[][] pictureZero() {
        String[][] zero = {
                {" *********  "},
                {"*         * "},
                {"*       * * "},
                {"*      *  * "},
                {"*     *   * "},
                {"*    *    * "},
                {"*   *     * "},
                {"*  *      * "},
                {"* *       * "},
                {" *********  "}

        };

        return zero;
    }

    private static String[][] pictureOne() {
        String[][] one = {
                {"     *   "},
                {"   * *   "},
                {"  *  *   "},
                {" *   *   "},
                {"     *   "},
                {"     *   "},
                {"     *   "},
                {"     *   "},
                {"     *   "},
                {"   ***** "}

        };

        return one;
    }

    private static String[][] pictureTwo() {
        String[][] two = {
                {"******** "},
                {"*      * "},
                {"*      * "},
                {"      *  "},
                {"    *    "},
                {"  *      "},
                {"*        "},
                {"*        "},
                {"*        "},
                {"******** "}

        };

        return two;
    }

    private static String[][] pictureThree() {
        String[][] three = {
                {" ********  "},
                {"*        * "},
                {"         * "},
                {"         * "},
                {"   ******* "},
                {"         * "},
                {"         * "},
                {"         * "},
                {"*        * "},
                {" ********  "}

        };

        return three;
    }

    private static String[][] pictureFour() {
        String[][] four = {
                {"*           "},
                {"*           "},
                {"*      *    "},
                {"*      *    "},
                {"*      *    "},
                {"**********  "},
                {"       *    "},
                {"       *    "},
                {"       *    "},
                {"       *    "},

        };

        return four;
    }

    private static String[][] pictureFive() {
        String[][] five = {
                {"*********** "},
                {"*           "},
                {"*           "},
                {"*           "},
                {"**********  "},
                {"          * "},
                {"          * "},
                {"          * "},
                {"*         * "},
                {" *********  "}

        };

        return five;
    }

    private static String[][] pictureSix() {
        String[][] six = {
                {"**********  "},
                {"*           "},
                {"*           "},
                {"*           "},
                {"**********  "},
                {"*         * "},
                {"*         * "},
                {"*         * "},
                {"*         * "},
                {" *********  "}

        };

        return six;
    }

    private static String[][] pictureSeven() {
        String[][] seven = {
                {"*********** "},
                {"*         * "},
                {"*         * "},
                {"          * "},
                {"         *  "},
                {"        *   "},
                {"       *    "},
                {"      *     "},
                {"     *      "},
                {"    *       "}

        };

        return seven;
    }

    private static String[][] pictureEight() {
        String[][] eight = {
                {" **********  "},
                {"*          * "},
                {"*          * "},
                {"*          * "},
                {" **********  "},
                {"*          * "},
                {"*          * "},
                {"*          * "},
                {"*          * "},
                {" **********  "}

        };

        return eight;
    }

    private static String[][] pictureNine() {
        String[][] nine = {
                {" *********  "},
                {"*         * "},
                {"*         * "},
                {"*         * "},
                {" *********  "},
                {"          * "},
                {"          * "},
                {"          * "},
                {"*         * "},
                {" *********  "}

        };

        return nine;
    }
}


