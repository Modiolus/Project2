package myLessons.Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) throws FileNotFoundException {
        /* если прописать в методе(ОБЪЯВЛЕННИЕ) throws FileNotFoundException то компилятор не ругаетс
        я и приложение запустится,
        * но само исключение не обработано через try catch и значит может быть выброшена ошибка в консоли*/

        /*в блоке try код, который может дать исключение
        * в блоке catch пишем в параметрах тип исключения(класс), таким образом обрабатываем исключение
        * catch блоков может быть несколько, try и finally - только по одному
        * в блоке finally код вызовется в любом случае независимо от того будет ли поймано исключение
        * блок finally является необязательным*/
//        int [] array = {4, 8, 1};
//        System.out.println("We have an array");
//
//        try {
//            System.out.println(array[1]);
//            System.out.println("Check exception");
//        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Exception was called");
//        }
//        File f = new File("src\\myLessons\\Exception\\train.txt");
//        FileInputStream fis = new FileInputStream(f);
//        try {
//            FileInputStream fis = new FileInputStream(f);
//            System.out.println("Check exception");
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("Exception was called: " + e);
//        } finally {
//            System.out.println("Finally block");
//        }
    }
}
