package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MaximumSubArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/C5326069/IdeaProjects/interview-prep/src/resources/max_subarray_sum_data_1.txt"));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        Long start = new Date().getTime();
        IntStream.range(0, T).forEach(TItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int n = Integer.parseInt(firstMultipleInput[0]);
                long m = Long.parseLong(firstMultipleInput[1]);
                List<Long> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Long::parseLong)
                        .collect(toList());

                long result = maxSubArraySum(a, m);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Long end = new Date().getTime();
        System.out.println("Time Taken: " +(end-start) +" milliseconds");
    }

    public static long maxSubArraySum(List<Long> a, long m) {
        long size = a.size();
        long max_sum_mod = 0;
        for(int i = 0; i<size; i++) {
            long sum = 0;
            long max = a.get(0);
            for(int j=i; j<size; j++) {
//                if(j>=i) {
                    sum += a.get(j);
                    sum = Math.max(sum, 0);
                    max = Math.max(sum, max);
                    long x = max%m;
                    if(x>max_sum_mod) max_sum_mod = x;
//                }
            }
        }
        return max_sum_mod;
    }
}
