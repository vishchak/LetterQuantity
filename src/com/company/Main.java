package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("ukrainian anthem.txt");
        letterQuantity(file);
    }

    public static List<Character> listCreater(File file) throws FileNotFoundException, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        List<Character> lst = new ArrayList<>();
        String str;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((str = br.readLine()) != null) {
            if (!str.isEmpty()) {
                String letters = str.toLowerCase(Locale.ROOT);
                char[] chars = letters.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (Character.isLetter(chars[i])) {
                        lst.add(chars[i]);
                    }
                }
            }
        }
        return lst;
    }


    public static Map letterQuantity(File file) {

        Map<Character, Integer> stat = new HashMap<>();
        try {
            for (Character letter : listCreater(file)) {
                Integer quantity = stat.get(letter);
                if (quantity == null) {
                    stat.put(letter, 1);
                } else {
                    stat.put(letter, quantity + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stat);
        return stat;
    }
}

