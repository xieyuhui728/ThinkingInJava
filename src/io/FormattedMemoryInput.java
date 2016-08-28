package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by 谢宇辉 on 2016/8/28 0028.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
//        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(
                    BufferedInputFile.read("F:\\develop\\workspace\\ThinkingInJava\\src\\io\\z_readme.txt").getBytes()));
            while (in.available()!=0){
                System.out.print((char)in.readByte());
            }
//        }catch (EOFException e){
//            System.out.println("end of stream");
//        }

    }
}
