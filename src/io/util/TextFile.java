package io.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by 谢宇辉 on 2016/8/28 0028.
 * 工具类，用来简化对文件的读写操作
 */
public class TextFile extends ArrayList<String> {
    //Read a file as a single string
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    //Write a single file in one method call
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Read a file,split by any regular expression
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    //Normally read by lines
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item : this) {
                    out.print(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Simple test
    public static void main(String[] args) {
        String file = read("F:\\develop\\workspace\\ThinkingInJava\\src\\io\\z_readme.txt");
        write("F:\\test.txt", file);
        TextFile text = new TextFile("F:\\test.txt");
        text.write("F:\\test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("F:\\develop\\workspace\\ThinkingInJava\\src\\io\\z_readme.txt","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
