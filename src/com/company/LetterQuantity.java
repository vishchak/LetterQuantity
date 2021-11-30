package com.company;

import java.io.*;
import java.util.*;

public class LetterQuantity {
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


    public static Map<Character, Integer> letterQuantity(File file) {

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
        stat.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
        return stat;
    }
}
