//First semester Programing test practice check in pdfs Probetest_WS25

import java.util.Arrays;

public class Day7 {
    int[][] removeLeadingZeros(int[][] inputArray){
        int[][] returnArray = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i][0] == 0){
                // wie viele führende 0 sind es?
                int count = 0;
                while (count < inputArray[i].length && inputArray[i][count] == 0) {
                    count++;
                }
                returnArray[i] = new int[inputArray[i].length-count];

                for (int j = 0; j < returnArray[i].length; j++) {
                    returnArray[i][j] = inputArray[i][j+count];
                }
            }else {
                returnArray[i] = inputArray[i];
            }
        }
        return returnArray;
    }
    void mask(int[][] inputArray, int[] rows, int[] cols){
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (cols[j] < inputArray[rows[i]].length){
                    inputArray[rows[i]][cols[j]]= 0;
                }
            }
        }
    }

    String replicateCharacters(String sequence, String repSequence){
        if (sequence.isEmpty()){
            return "";
        }
        if (repSequence.charAt(0) == '1'){
            return "" + sequence.charAt(0)+ sequence.charAt(0) +replicateCharacters(sequence.substring(1),repSequence.substring(1));
        }else {
            return "" + sequence.charAt(0)+ replicateCharacters(sequence.substring(1),repSequence.substring(1));
        }
    }
    static void main(String[] args) {
        Day7 d = new Day7();
        int[][] test1 = {{0, 2, 4}, {2, 0, 0}, {0, 0, 1}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3}, {1, 2, 3, 4, 5}};
        int[][] test3 = {{2}, {0, 7}, {6, 7, 8}, {6, 0}, {0, 0}};
        String seq1 = "ABA";

        System.out.println("vorgegebene Testfälle");

        System.out.println("result1 = removeLeadingZeros(test1)");
        int[][] result1 = d.removeLeadingZeros(test1);
        System.out.println(Arrays.deepToString(result1));

        System.out.println("result2 = removeLeadingZeros(test3)");
        int[][] result2 = d.removeLeadingZeros(test3);
        System.out.println(Arrays.deepToString(result2));

        System.out.println("mask(test2,new int[]{1,2,3},new int[]{0,1,4})");
        d.mask(test2,new int[]{1,2,3},new int[]{0,1,4});
        System.out.println(Arrays.deepToString(test2));

        System.out.println("mask(test3,new int[]{0,2,4},new int[]{0,1})");
        d.mask(test3,new int[]{0,2,4},new int[]{0,1});
        System.out.println(Arrays.deepToString(test3));

        System.out.println("mask(test1,new int[]{},new int[]{0,1})");
        d.mask(test1,new int[]{},new int[]{0,1});
        System.out.println(Arrays.deepToString(test1));

        System.out.println("replicateCharacters(seq1, \"010\")");
        System.out.println(d.replicateCharacters(seq1, "010"));

        System.out.println("replicateCharacters(\"SAMBA\", \"10001\")");
        System.out.println(d.replicateCharacters("SAMBA", "10001"));
    }
}
