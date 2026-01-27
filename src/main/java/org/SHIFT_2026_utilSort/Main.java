package org.SHIFT_2026_utilSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] words = sc.nextLine().split(" ");

        String[] words = { "-o", "qwe", "-o", "D:\\!База данных JAVA\\ЦФТ\\SHIFT_2026_utilSort", "-p", "-p", "-p", "qwe1.txt", "-o", "qwe2.txt", "-a" };

        InputParser parser = new InputParser();
        parser.parce(words);

        //System.out.println("-p".matches("^[^/:*?\"<>\\\\|]+$"));
        ConfigurationUtil.getInstance().print();



//        String element = "qwevvv";
//        String path = ".";
//        try {
//            File file = new File(path, "pr-" + "result.txt");
//
//            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
//
//            bw.write(element + System.lineSeparator());
//
//            bw.flush();
//        }
//        catch (IOException e) {
//            System.out.println("qweqwe!!!!: " + e.getMessage());
//        }

    }
}