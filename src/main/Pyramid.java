package main;

public class Pyramid {
    public static void main(String[] args) {
//        1
//        2  3
//        4  5  6
//        7  8  9  10
//        11 12 13 14 15
//        16 17 18 19 20 21
//        22 23 24 25 26 27 28
//        29 30 31 32 33 34 35 36
//        37 38 39 40 41 42 43 44 45
//        46 47 48 49 50 51 52 53 54 55
        int lastKnown = 0;
        int numberOfElementsToPrint = 100;
        int numberOfRows = 20;
        for(int i = 0; i<numberOfRows; i++) {
            int numCount = 0;
            for(int j = lastKnown; j<numberOfElementsToPrint; j++) {
                System.out.print(j+1 +" ");
                numCount++;
                lastKnown = j+1;
                if(numCount>=i+1) break;
            }
            System.out.println();
        }
    }
}
