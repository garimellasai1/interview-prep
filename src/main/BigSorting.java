package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/C5326069/IdeaProjects/interview-prep/src/resources/big_sorting_data.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        List<String> result = bigSorting(unsorted);
        System.out.println(result);
        bufferedReader.close();
    }
    public static List<String> bigSorting(List<String> unsortedStrings) {
        return unsortedStrings.stream().sorted((a,b)->{
            if(a.length()>b.length()){
                return 1;
            } else if (a.length()<b.length()) {
                return -1;
            } else {
                return a.compareTo(b);
            }
        }).collect(Collectors.toList());
    }
}
