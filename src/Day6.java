import java.util.Arrays;

public class Day6 {
    int[][] rearrange(int[][] inputArray){

        int zeilen = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                zeilen++;
            }
        }


        //in eindimisionales umschreiben wegen leichtikeit
        int[] supiArray = new int[zeilen+4];
        int x = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                supiArray[x]= inputArray[i][j];
                x++;
            }
        }
        System.out.println(Arrays.toString(supiArray));

        //zeilen berechen
        if (zeilen % 4 == 0){
            zeilen = zeilen / 4;
        }else {
            zeilen = zeilen / 4 + 1;
        }

        int [][] returnArray = new int[zeilen][4];

        //neues array befüllen
        int current = 0;
        for (int i = 0; i < returnArray.length; i++) {
            if (i % 2 ==0){
                for (int j = 0; j < returnArray[i].length; j++) {
                    returnArray[i][j]= supiArray[current];
                    current++;
                }

            }else {
                for (int j = returnArray[i].length-1; j >= 0; j--) {
                    returnArray[i][j]= supiArray[current];
                    current++;
                }
            }

        }
        return returnArray;
    }
    /* diese lösung geht zwar und auch nicht schlecht aber das waere so viel einfachaer gegangen

    int[][] rearrange(int[][] input) {

    // Anzahl aller Elemente
    int total = 0;
    for (int i = 0; i < input.length; i++) {
        total += input[i].length;
    }

    int rows = (total + 3) / 4;
    int[][] result = new int[rows][4];

    int index = 0; // wie viele Werte schon geschrieben

    for (int i = 0; i < input.length; i++) {
        for (int j = 0; j < input[i].length; j++) {

            int row = index / 4;
            int col = index % 4;

            if (row % 2 == 1) {
                col = 3 - col; // rückwärts
            }

            result[row][col] = input[i][j];
            index++;
        }
    }

    return result;
    }

     */

    void label(int[][] inputArray){
        for (int i = 1; i < inputArray.length; i++) {
            boolean match = true;
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i-1][j]!= inputArray[i][j]){
                    match = false;
                    break;
                }
            }
            if (inputArray[i-1].length == inputArray[i].length && match){
                for (int j = 0; j < inputArray[i].length; j++) {
                    inputArray[i][j] = -9;
                    inputArray[i-1][j] = -9;
                }
            }
        }
    }
/*
    das geht nicht da java nicht vergleicht ob der inhalt gleich ist so wie ich in mathe denken wurde
    sonder java fragt sich Sind es exakt dasselbe Objekt im Speicher?

    void label(int[][] inputArray){
            for (int i = 1; i < inputArray.length; i++) {
                if (inputArray[i-1] == inputArray[i]){
                    for (int j = 0; j < inputArray[i].length; j++) {
                        inputArray[i][j] = -9;
                        inputArray[i-1][j] = -9;
                    }
                }
            }
        }
 */

    // das ist mal ein ganz anderer weg so habe ich rekrusion noch nie geshen

    int findMaxOppositeSum(int[] seq, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int current = seq[start] + seq[end];
        int rest = findMaxOppositeSum(seq, start + 1, end - 1);

        return Math.max(current, rest);
    }



    static void main(String[] args) {
        Day6 d = new Day6();

        int[][] test1 = {{5, 2, 4}, {8, 5, 4}, {9, 6, 8, 7}};
        int[][] test2 = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
        int[][] test3 = {{6}, {2, 4}, {2, 4}, {2, 4}, {4, 2}};
        int[] seq1 = {4, 3, 2, 1, 10, 5, 5, 5};

        System.out.println("vorgegebene Testfälle:");

        System.out.println("result1 = rearrange(test1)");
        int[][] result1 = d.rearrange(test1);
        System.out.println(Arrays.deepToString(result1));

        System.out.println("result2 = rearrange(test3)");
        int[][] result2 = d.rearrange(test3);
        System.out.println(Arrays.deepToString(result2));

        System.out.println("label(test1)");
        d.label(test1);
        System.out.println(Arrays.deepToString(test1));

        System.out.println("label(test2)");
        d.label(test2);
        System.out.println(Arrays.deepToString(test2));

        System.out.println("label(test3)");
        d.label(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println("findMaxOppositeSum(seq1, 0, 7)");
        System.out.println(d.findMaxOppositeSum(seq1, 0, 7));

        System.out.println("findMaxOppositeSum(seq1, 0, 5)");
        System.out.println(d.findMaxOppositeSum(seq1, 0, 5));

        System.out.println("findMaxOppositeSum(seq1, 4, 7)");
        System.out.println(d.findMaxOppositeSum(seq1, 4, 7));
    }
}
