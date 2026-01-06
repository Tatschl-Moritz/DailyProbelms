//First semester Programing test practice check in pdfs Probetest_WS25

import java.util.Arrays;

public class Day11 {
    static int[][] repeat(int[][] input, int[] reps) {
        int[][] retrunArray = new int[input.length][];

        for (int i = 0; i < retrunArray.length; i++) {
            retrunArray[i] = new int[input[i].length + input[i].length * Math.abs(reps[i])];
        }

        for (int i = 0; i < retrunArray.length; i++) {
            if (reps[i] >= 0) {
                int current = 0;
                for (int j = 0; j < retrunArray[i].length; j++) {
                    if (current >= input[i].length) {
                        current = 0;
                    }
                    retrunArray[i][j] = input[i][current];
                    current++;
                }
            } else {
                int current = input[i].length - 1;
                for (int j = 0; j < retrunArray[i].length; j++) {
                    if (current < 0) {
                        current = input[i].length - 1;
                    }
                    retrunArray[i][j] = input[i][current];
                    current--;
                }
            }

        }
        return retrunArray;
    }

    static void rasp(int[][] input){
        int wiederholungen = input.length;
        if(input.length % 2 == 1){
            wiederholungen = wiederholungen -1;
        }
        for (int i = 0; i < wiederholungen; i = i + 2) {
            int[] helpArray = input[i];
            input[i] = new int[helpArray.length-1];
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = helpArray[j];
            }

            int x = helpArray[helpArray.length-1];
            helpArray = input[i+1];
            input[i+1] = new int[helpArray.length+1];
            for (int j = 0; j < input[i+1].length-1; j++) {
                input[i+1][j] = helpArray[j];
            }
            input[i+1][input[i+1].length-1] = x;
        }
    }

    static boolean hasNOrderedPairs(int[] seq, int n, int index){
        if (n < 0){
            return false;
        }
        if (index >= seq.length-1){
            return n == 0;
        }

        //richtig geordnet
        if (seq[index] <= seq[index+1]){
            return hasNOrderedPairs(seq, n-1, index +1);
        }else {
            return hasNOrderedPairs(seq, n, index +1);
        }

    }

    public static void main (String[]args){
        int[][] test1 = {{1}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2}};
        int[][] test2 = {{1, 2, 3}, {0}, {1, 2}, {0}, {1}};
        int[] seq = {2, 8, 8, 5, 2, 5, 7, 3};
        System.out.println("_______________________________________________");
        System.out.println("result1 = repeat(test1, new int[]{1, -2, 1, 0})");
        int[][] result1 = repeat(test1, new int[]{1, -2, 1, 0});
        System.out.println(Arrays.deepToString(result1));

        System.out.println("_______________________________________________");
        System.out.println("result2 = repeat(test2, new int[]{1, 0, -3, 2, 0})");
        int[][] result2 = repeat(test2, new int[]{1, 0, -3, 2, 0});
        System.out.println(Arrays.deepToString(result2));

        System.out.println("_______________________________________________");
        System.out.println("rasp(test1)");
        rasp(test1);
        System.out.println(Arrays.deepToString(test1));

        System.out.println("_______________________________________________");
        System.out.println("rasp(test2)");
        rasp(test2);
        System.out.println(Arrays.deepToString(test2));

        System.out.println("_______________________________________________");
        System.out.println("hasNOrderedPairs(seq, 4, 0)");
        System.out.println(hasNOrderedPairs(seq, 4, 0));

        System.out.println("_______________________________________________");
        System.out.println("hasNOrderedPairs(seq, 2, 2)");
        System.out.println(hasNOrderedPairs(seq, 2, 2));

        System.out.println("_______________________________________________");
        System.out.println("hasNOrderedPairs(seq, 1, 3)");
        System.out.println(hasNOrderedPairs(seq, 1, 3));

        System.out.println("_______________________________________________");
        System.out.println("hasNOrderedPairs(seq, 3, 3)");
        System.out.println(hasNOrderedPairs(seq, 3, 3));

        System.out.println("_______________________________________________");
        System.out.println("hasNOrderedPairs(seq, 0, 6)");
        System.out.println(hasNOrderedPairs(seq, 0, 6));
    }
}
