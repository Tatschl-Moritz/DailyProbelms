//First semester Programing test practice check in pdfs Probetest_WS25

import java.util.Arrays;

public class Day5 {
    int[][] labelPath(int n, int[][] points){
        int[][] returnArray = new int[n][n];
        for (int i = 0; i < returnArray.length; i++) {
            for (int j = 0; j < returnArray[i].length; j++) {
                returnArray[i][j] = n;
            }
        }
        for (int i = 0; i < points.length; i++) {
            returnArray[points[i][0]][points[i][1]]= -1;
        }
        return returnArray;
    }

    void findMatches(int[][] data, int[] pattern, int[] target){
        for (int i = 0; i < data.length; i++) {
            int speichi = 0;

            for (int j = 0; j <= data[i].length - pattern.length; j++) {
                boolean match = true;

                for (int k = 0; k < pattern.length; k++) {
                    if (data[i][j + k] != pattern[k]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    speichi++;
                }
            }
            target[i] = speichi;
        }
    }

    String insertMiddle(String input, String seps){
        if (seps.isEmpty()){
            return input;
        }
        if (input.length() <= 1){
            return input;
        }
        int mitte = input.length()/2;
        return insertMiddle(input.substring(0,mitte),seps.substring(1))+seps.charAt(0)+insertMiddle(input.substring(mitte),seps.substring(1));
    }

    static void main(String[] args) {
        Day5 d = new Day5();

        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        System.out.println("vorgegebene Testfälle");

        System.out.println("labelPath(3, new int[][] {})");
        System.out.println(Arrays.deepToString(d.labelPath(3, new int[][]{})));

        System.out.println("labelPath(4, data0)");
        System.out.println(Arrays.deepToString(d.labelPath(4, data0)));

        System.out.println("findMatches(data0, data0[1], target1)");
        d.findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));

        System.out.println("findMatches(data1, data0[1], target1)");
        d.findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));

        System.out.println("findMatches(data1, data0[2], target2)");
        d.findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));

        System.out.println("insertMiddle(\"XY\", \"abc\")");
        System.out.println(d.insertMiddle("XY", "abc"));

        System.out.println("insertMiddle(\"01234\", \"abc\")");
        System.out.println(d.insertMiddle("01234", "abc"));

        System.out.println("insertMiddle(\"01234567890123\", \"./-\")");
        System.out.println(d.insertMiddle("01234567890123", "./-"));
    }
}
