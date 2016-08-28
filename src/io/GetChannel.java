package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 谢宇辉 on 2016/8/28 0028.
 * nio：结构更接近于系统执行IO的方式
 * 通道和缓冲器
 */
public class GetChannel {
    private static final int SIZE = 1024;

    public static void main(String[] args) throws Exception {
        //Write a file
        FileChannel fc = new FileOutputStream("F:\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        //Add to the end of the file
        fc = new RandomAccessFile("F:\\data.txt", "rw").getChannel();
        fc.position(fc.size());//move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        //Read the file
        fc = new FileInputStream("F:\\data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(SIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }

    }
}
