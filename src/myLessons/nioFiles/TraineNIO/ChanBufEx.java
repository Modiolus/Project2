package myLessons.nioFiles.TraineNIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChanBufEx {
    public static void main(String[] args) {
        try (RandomAccessFile rFile =
                     new RandomAccessFile("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\TraineNIO\\trainTestIO.txt", "rw");

             FileChannel fileChannel = rFile.getChannel();

        ) {
            StringBuilder str = new StringBuilder();

            ByteBuffer bBuffer = ByteBuffer.allocate(25);

            int bytRead = fileChannel.read(bBuffer);

            while (bytRead > 0) {
                bBuffer.flip();
                System.out.println(bytRead);

                while (bBuffer.hasRemaining()) {
                    str.append((char) bBuffer.get());

                }
                bBuffer.clear();
                bytRead = fileChannel.read(bBuffer);

            }
            System.out.println(str);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (RandomAccessFile rfile =
//                     new RandomAccessFile("D:\\Projects\\Project2\\src\\myLessons\\nioFiles\\TraineNIO\\trainTestIO.txt", "rw");
//             FileChannel channel = rfile.getChannel();
//
//        ){
//            StringBuilder str = new StringBuilder();
//           ByteBuffer buffer = ByteBuffer.allocate(25);
//         int bytRead = channel.read(buffer);
//
//         while (bytRead>0){
//             System.out.println(bytRead);
//             buffer.flip();
//             while (buffer.hasRemaining()){
//                 str.append((char)buffer.get());
//
//
//             }
//             buffer.clear();
//             bytRead = channel.write(buffer);
//         }
//            System.out.println(str);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
