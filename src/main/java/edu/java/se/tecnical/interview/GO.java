package edu.java.se.tecnical.interview;

import java.util.*;
import java.io.*;
import java.math.*;

class GO {

    public static String[] filterWords(String[] words, String letters) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        var r = new String[words.length];
        var d = List.of(words);
        int i = 0;
        for (String word : words) {
            if (d.contains(word)) {
                r[i] = word;

            }
            i++;
        }

        return r; //borrar {
    }

    /* Ignore and do not change the code below */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
        }
        String letters = in.nextLine();
        PrintStream outStream = System.out;
        System.setOut(System.err);
        String[] remaining = filterWords(words, letters);
        System.setOut(outStream);
        for (int i = 0; i < remaining.length; i++) {
            System.out.println(remaining[i]);
        }
    }
    /* Ignore and do not change the code above */

    public interface Letra {
    }

    ;

    /**
     * @return the sum of integers whose index is between n1 and​​​​​​‌​​‌‌‌‌​‌​​​‌​‌‌‌‌‌‌​​​​‌ n2
     */
    public static int calc(int[] array, int n1, int n2) {
        if (!(0 <= n1 && n1 <= n2 && n2 < array.length))
            throw new IllegalArgumentException();

    int result =0;
        for (int n :
                array) {
            result+=n;
        }

        return result;

    }

}
