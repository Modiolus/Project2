package hillel.lesson17.charStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class charStream {
    public static void main(String[] args) throws IOException {
//        try (FileReader fr = new FileReader("D:\\Projects\\Project2\\src\\hillel\\lesson17\\charStream\\input.txt");
//             FileWriter fw = new FileWriter("D:\\Projects\\Project2\\src\\hillel\\lesson17\\charStream\\output.txt")) {
//            List<Character> list = new ArrayList<>();
//            int a;
//            while ((a = fr.read()) != -1) {
//                list.add((char) a);
//                fw.write(a);
//            }
//            System.out.println(list);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileReader fr = new FileReader("D:\\Projects\\Project2\\src\\hillel\\lesson17\\charStream\\input.txt");
        FileWriter fw = new FileWriter("D:\\Projects\\Project2\\src\\hillel\\lesson17\\charStream\\output.txt");
        List<Character> list = new ArrayList<>();
        int a;
        while ((a = fr.read()) != -1) {
            list.add((char) a);
            fw.write(a);
        }
        System.out.println(list);
    }
}
