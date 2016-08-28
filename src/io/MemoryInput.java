package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by 谢宇辉 on 2016/8/28 0028.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException{
        StringReader in = new StringReader(BufferedInputFile.read("F:\\develop\\workspace\\ThinkingInJava\\src\\io\\z_readme.txt"));
        int c;
        while((c=in.read())!=-1){
            System.out.print((char)c);
        }
    }
}
