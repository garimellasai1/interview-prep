package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberLineJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/C5326069/IdeaProjects/interview-prep/src/resources/kangaroo_data.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
        bufferedReader.close();
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        float jumps = (float)(x1-x2)/(v2-v1);
        System.out.println((x1-x2));
        System.out.println((v2-v1));
        System.out.println(jumps);
        System.out.println();
        if(jumps>0 && (x1-x2)%(v2-v1)==0) {
            return "YES";
        }
        return "NO";
    }
}
