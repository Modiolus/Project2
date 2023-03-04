package hillel.lesson17;

import java.io.*;

public class FilesDir {
    public static void main(String[] args) throws IOException {
      //СОЗДАНИНЕ КАТАЛОГОВ
        String nameDir1 = "D:\\Projects\\Project2\\src\\hillel\\lesson17";
        String nameDir2 = nameDir1 + "/test_in/test_inn";
        String nameDir3 = nameDir1 + "/test_in";

        File dir = new File(nameDir2);
        File dir1 = new File(nameDir3);

        System.out.println(dir.mkdir());  // mkdir создает только последний каталог
        System.out.println(dir1.mkdir()); // mkdir создает только последний каталог
        /* первый запуск - он создает /test_in поэтому false и true
         * второй запуск - он создает /test_in/test_inn поэтому true и false
         * третий запуск - он выдаст false и false потому что у же всё создано и создавать нечего*/

        //  System.out.println(dir.mkdirs()); // mkdirs создает только полный путь каталога

        // МЕТОДЫ:
        System.out.println(dir.getName());
        System.out.println("Это директория?: " + dir.isDirectory());
        System.out.println("Это файл?: " + dir.isFile());
        System.out.println("Путь родителя: " + dir.getParent());
        System.out.println("Абсолютный путь: " + dir.getAbsolutePath());
        System.out.println(dir.canRead());
        System.out.println(dir.canWrite());
        System.out.println(dir.setReadable(true)); //блокирует возможность чтения false
        System.out.println(dir.setWritable(true)); //блокирует возможность писать если false
        System.out.println(dir.lastModified());
        //System.out.println(dir.getPath());

        //СОЗДАНИЕ ФАЙЛОВ
        String filename1 = "example1.txt";
        String filename2 = "example2.txt";
        String filename3 = "example3.txt";

        File file1 = new File(nameDir1, filename1);
        File file2 = new File(nameDir2, filename2);
        File file3 = new File(nameDir3, filename3);
        file1.setWritable(true); //false блокирует запись в файл, true - соответственно открывает

        System.out.println(file1.createNewFile());
        System.out.println(file2.createNewFile());
        System.out.println(file3.createNewFile());
        System.out.println("Файл 1 есть?: " + file1.exists());
        System.out.println("Файл 2 есть?: " + file2.exists());
        System.out.println("Файл 3 есть?: " + file3.exists());
        System.out.println(file1.lastModified()); // время создания в мс
        System.out.println(file3.lastModified()); // время создания в мс

        System.out.println("file1 это файл?: " + file1.isFile());
        System.out.println("file1 это директория?: " + file1.isDirectory());
        System.out.println("file1 скрыт?: " + file1.isHidden());
        System.out.println("file1 имеет абсолютн путь?: " + file1.isAbsolute());

        // ЗАПИСЬ В ФАЙЛ
        // !!! БЕЗ try catch НЕ ЗАПИСЫВЕТ !!!

        try (FileWriter fw = new FileWriter("D:\\Projects\\Project2\\src\\hillel\\lesson17\\example1.txt")) {
            String s = "Hello world";
            int a = 1;
           // for (char c : s.toCharArray()) {
                fw.write(s + a); // записывает без foreach и toCharArray
            //}
            String str = "World";
            FileWriter wf = new FileWriter("D:\\Projects\\Project2\\src\\hillel\\lesson17\\example1.txt");

            fw.append('\n');
            fw.append(str);

            BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fw), true));
            writer.append(' ');
            writer.append(str);

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
