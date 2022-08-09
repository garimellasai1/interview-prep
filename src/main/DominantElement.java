package main;

import java.util.Arrays;
import java.util.List;

public class DominantElement {
    public static void main(String[] args) {
        List<Integer> givenArray = Arrays.asList(new Integer[] {2, 1, 3, 2, 1});
        int x = calculate(givenArray);
        System.out.println(x);
    }
    public static int calculate(List<Integer> array) {
        int count = 0;
        for (int i = 0; i< array.size(); i++) {
            for(int j=i+1; j<array.size(); j++) {
                if(((array.get(i)+array.get(j))/2f) == (array.get(i) & array.get(j))) {
                    count ++;
                }
            }
        }
        return count;
    }
}
