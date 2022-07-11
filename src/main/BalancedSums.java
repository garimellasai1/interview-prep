package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BalancedSums {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/C5326069/IdeaProjects/interview-prep/src/resources/balanced_sums_data.txt"));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        Long start = new Date().getTime();
        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                List<Integer> array = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(array);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Long end = new Date().getTime();
        System.out.println("Time Taken: " +(end-start) +" milliseconds");
    }
    public static String balancedSums(List<Integer> arr) {
        int arraySum = arr.stream().mapToInt(Integer::intValue).sum();
        int leftSubArraySum = 0;
        for(int i = 0; i<arr.size(); i++) {
//            List<Integer> leftSubArray = arr.subList(0, i);
            if(((leftSubArraySum * 2) + arr.get(i)) == arraySum) {
                return "YES";
            } else {
                leftSubArraySum += arr.get(i);
            }
        }
        return "NO";
    }
}
