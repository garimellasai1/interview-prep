package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCount {
    public static void main(String[] args) {
        String input = "mississippi";
        char[] chars = input.toCharArray();
        Map<Character, Integer> characterCount = new HashMap<>();
        for(char c : chars) {
            if(characterCount.containsKey(c)) {
                int existingCount = characterCount.get(c);
                characterCount.put(c, ++existingCount);
            } else {
                characterCount.put(c, 1);
            }
        }

        Map.Entry<Character, Integer> entry = null;
        int maxValue = 0;
        for(Map.Entry<Character, Integer> element : characterCount.entrySet()) {
            int value = element.getValue();
            if(value>maxValue) {
                maxValue = value;
                entry = element;
            }
        }
        System.out.println("required character is: "+entry.getKey());
    }
}
