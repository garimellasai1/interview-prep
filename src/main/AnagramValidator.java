package main;

import java.util.Date;

public class AnagramValidator {
    public static void main(String[] args) {
        Long start = new Date().getTime();
        System.out.println(isAnagram("cat", "tac"));
        Long end = new Date().getTime();
        System.out.println((end-start) + "ms");
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (int i = 0; i<s.length(); i++) {
            char cS = s.charAt(i);
            freqS[cS - 'a']++;

            char cT = t.charAt(i);
            freqT[cT - 'a']++;
        }

        for(int i = 0; i<26; i++) {
            if(freqS[i]!=freqT[i]) {
                return false;
            }
        }
        return true;
    }
}
