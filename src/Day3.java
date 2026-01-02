//First semester Programing test practice check in pdfs Probetest_WS25

import java.util.Arrays;

public class Day3 {

    //This is my own version
    int[][] generate(int[][] input){
        int[][] returnArray = new int[input.length*2-1][];
        int currentPos = 0;
        for (int i = 0; i < input.length; i++) {
            returnArray[i]= new int[input.length-i];
            for (int j = 0; j < returnArray[i].length; j++) {
                returnArray[i][j]= input[i][j];
            }
            currentPos++;
        }
        int a = 2;
        for (int i = input.length-2; i >= 0; i--) {
            returnArray[currentPos]= new int[a];
            for (int j = 0; j < returnArray[currentPos].length; j++) {
                returnArray[currentPos][j]= input[i][j];
            }
            currentPos++;
            a++;
        }
        return returnArray;
    }
    /* this is a much simplyfied version

    import java.util.Arrays;

    public class Day3 {

        int[][] generate(int[][] input) {
            int n = input.length;
            int[][] out = new int[2 * n - 1][];

            for (int k = 0; k < out.length; k++) {
                int len = n - Math.abs(k - (n - 1));          // 3,2,1,2,3
                int src = (k < n) ? k : (2 * n - 2 - k);      // 0,1,2,1,0

                out[k] = new int[len];
                for (int j = 0; j < len; j++) {
                    out[k][j] = input[src][j];
                }
            }
            return out;
        }

        public static void main(String[] args) {
            int[][] test1 = { {5, 2, 4}, {2, 7, 3}, {9, 5, 8} };
            Day3 d = new Day3();
            System.out.println(Arrays.deepToString(d.generate(test1)));
        }
    }

     */

    //I did not see the void in the beginning so i did it wrong way around
    void reorder(int[][] input){

        for (int i = 0; i < input.length; i++) {
            int a = 0;
            for (int j = input[i].length-1; j > 0; j--) {
                int tmp = input[i][a];
                input[i][a] = input[i][j];
                input[i][j] = tmp;
                a++;
            }
        }
    }

    boolean isPresentNTimes(String sequence, char marker, int count){
        //ABBAACBA
        if (count < 0) return false;// zu oft gesehen
        if (sequence.isEmpty()) return count == 0;


        if (sequence.charAt(0) == marker){
            return isPresentNTimes(sequence.substring(1), marker, count-1);

        }else {
             return isPresentNTimes(sequence.substring(1), marker, count);
        }
    }

    public static void main(String[] args) {
        //angaben Testfälle
        int[][] test1 = { {5, 2, 4}, {2, 7, 3}, {9, 5, 8} };
        int[][] test2 = { {1} };
        int[][] test3 = { {6, 7, 8}, {7, 5, 3, 1}, {2} };
        String seq1 = "ABBAACBA";
        Day3 d = new Day3();
        System.out.println("vorgegebenen Testfälle");

        System.out.println("result 1 = ");
        int[][] result1 = d.generate(test1);
        System.out.println(Arrays.deepToString(result1));

        System.out.println("result 2 = ");
        int[][] result2 = d.generate(test2);
        System.out.println(Arrays.deepToString(result2));

        System.out.println("reorder(result1) = ");
        d.reorder(result1);
        System.out.println(Arrays.deepToString(result1));

        System.out.println("reorder(result2) = ");
        d.reorder(result2);
        System.out.println(Arrays.deepToString(result2));

        System.out.println("reorder(test3) = ");
        d.reorder(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println("isPresentNTimes(seq1, 'A', 4)");
        System.out.println(d.isPresentNTimes(seq1, 'A', 4));

        System.out.println("isPresentNTimes(seq1, 'A', 3)");
        System.out.println(d.isPresentNTimes(seq1, 'A', 3));

        System.out.println("isPresentNTimes(seq1, 'A', 3)");
        System.out.println(d.isPresentNTimes(seq1, '5', 3));

        System.out.println("isPresentNTimes(seq1, 'A', 3)");
        System.out.println(d.isPresentNTimes(seq1, 'Z', 0));
    }
}
