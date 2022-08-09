package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// problem statement

// for a given string perform rotation operations with the help of the rotations string denoted as L=left, R=right and
// corresponding number as the number of rotations in each direction.

// after each rotation get the first character of the string and form a new string, firstCharString,
// with such first characters after each rotation

// check if the new string formed is an anagram of any of the substrings of a given string

public class StringRotations {
    public static void main(String[] args) {
        System.out.println(AnagramCheckAfterRotations("carrecerrc", "L2R2L3"));
    }

    public static String AnagramCheckAfterRotations(String str, String rotations) {
        List<Map<String, Integer>> rotationList = getRotations(rotations);
        String firstLetterString = "";
        String rotatedString = str;
        for(Map<String, Integer> rotationElement : rotationList) {
            if(rotationElement.containsKey("L")) {
                rotatedString = rotateLeft(rotatedString, rotationElement.get("L"));
            } else if(rotationElement.containsKey("R")) {
                rotatedString = rotateRight(rotatedString, rotationElement.get("R"));
            } else {
                throw new RuntimeException("invalid rotation");
            }
            firstLetterString+=rotatedString.substring(0,1);
        }

        if(determineAnagram(str, firstLetterString)) {
            return firstLetterString+"YES";
        } else {
            return firstLetterString+"NO";
        }
    }

    public static boolean determineAnagram(String str, String stringToCheck) {
        List<String> validSubstrings = generateValidSubStrings(str);
        for(String validSS : validSubstrings) {
            if(isAnagram(validSS, stringToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> generateValidSubStrings(String str) {
        List<String> validSubStrings = new ArrayList<>();
        for (int i = 0; i <= str.length() - 3; i++) {
            String substr = str.substring(i, i + 3);
            validSubStrings.add(substr);
        }
        return validSubStrings;
    }


    public static boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return false;
        }
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for(int i = 0; i<s1.length(); i++) {
            char c1 = s1.charAt(i);
            countS1[c1-'a']++;

            char c2 = s2.charAt(i);
            countS2[c2-'a']++;
        }

        for(int i = 0; i<26; i++) {
            if(countS1[i] != countS2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String rotateLeft(String str, int x) {
        return (str.substring(x) + str.substring(0,x));
    }

    public static String rotateRight(String str, int x) {
        return rotateLeft(str, str.length()-x);
    }

    public static List<Map<String, Integer>> getRotations (String rotations) {
        List<Map<String, Integer>> rotationList = new ArrayList<>();
        for(int i = 0; i<rotations.length(); i+=2) {
            Map<String, Integer> rotationData = new HashMap<>();
            rotationData.put(String.valueOf(rotations.charAt(i)), Integer.valueOf(String.valueOf(rotations.charAt(i+1))));
            rotationList.add(rotationData);
        }
        return rotationList;
    }
}
