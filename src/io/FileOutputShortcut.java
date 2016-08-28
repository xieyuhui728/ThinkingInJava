package io;

import java.io.*;

/**
 * Created by 谢宇辉 on 2016/8/28 0028.
 * 基本的文件输出
 */
public class FileOutputShortcut {
    static String file = "F:\\test.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("F:\\develop\\workspace\\ThinkingInJava\\src\\io\\z_readme.txt")));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
