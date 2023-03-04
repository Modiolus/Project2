package myLessons.ioFiles;

import java.io.FileWriter;
import java.io.IOException;

public class ExWriter {

    /*Файлы могуь быть текстовыми(text files)-читабельными для человека и бинарными(binary files)-нечитабельными для человека
    * FileReader и FileWriter используются для работы с текстовыми файлами
    * Stream в IO это не стримы в коллекциях. В данном случае программа читает из файла или записыает в файл через Stream*/

    public static void main(String[] args) throws IOException {
        String s1 = "I love ";
        String s2 = "java";
        String s4 = "October";
        char[] c = s4.toCharArray(); // TODO: 31.10.2021

        String s3 = "Класс File, определенный в пакете java.io, не работает напрямую с потоками. \n" +
                "Его задачей является управление информацией о файлах и каталогах.";
        FileWriter fileWriter = null;// объявляем здесь, чтобы fileWriter и fileWriter1 были видны в finally и их можно было закрыть
        FileWriter fileWriter1 = null;
//      try будет автоматически
        try {
            // при использовании true в параметрах при дальнейших запусках программы будет добавление текста в файле, а не перезапись
            // в скобках указывается место расположения файла. Важно понимать, что FileWriter и FileReader записывают
            // и читают посимвольно соответственно
            fileWriter = new FileWriter("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\FileTestEx.txt", true);
            fileWriter1 = new FileWriter("ExampleTest.txt", true);// указан относительный путь и тогда создаётся файл в корне проекта
            // если файла не существует то при таком написании аргумента как в fileWriter1 файл будет создан в корне проекта
            // true - позволяет добавлять текст к уже имеющемуся в файле. Иначе будет перезаписывать уже имеющиеся
            for (int i = 0; i < s4.length(); i++) {
                fileWriter.write(s4.charAt(i));
            } // можно записать и через цикл, но громоздко. Просто показал для примера!
            fileWriter.write(s1); // записывает посимвольно
            fileWriter.append("\n"+s2);
            fileWriter1.write(s3);
            fileWriter1.append("\n"+s3);
            // разница между write и append
            //write будет принимать только строку, которая не должна иметь значение null и возвращает void
            //append возьмет любую CharSequence, которая может быть null и вернуть Writer, чтобы она могла быть сцеплена.
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fileWriter.close();
            fileWriter1.close();
        }

        // ниже try with resources(try с русурсами) вписываем процесс в круглые скобки как в методе. Синтакис как буд-то try это метод
        // если писать несколько выражений в скобках, то нужно разделять их точкой с запятой
        // тогда не нужно закрывать поток .close() и не обязателен catch и тогда IOException в метод мэйн
//        try (FileWriter fileWriter = new FileWriter("D:\\Projects\\Project2\\src\\myLessons\\ioFiles\\FileTest.txt", true);
//             FileWriter fileWriter1 = new FileWriter("ExampleTest.txt")) {
//            fileWriter.write(s1);
//            fileWriter.append(s2);
//            fileWriter1.write(s3);
//
//        }
//
//
    }
}
