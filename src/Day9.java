import java.util.Arrays;

//First semester Programing test practice check in pdfs Probetest_WS25
public class Day9 {
    int[][] getRectangular(int[][] input){
        int l = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].length > l){
                l = input[i].length;
            }
        }

        int [][] returnArray = new int[input.length][l];
        for (int i = 0; i < returnArray.length; i++) {
            int current = 0;
            
            for (int j = 0; j < returnArray[i].length; j++) {
                if (current >= input[i].length) {
                    current = 0;
                }
                if (input[i].length == 0){
                    returnArray[i][j] = 0;
                }else {
                    returnArray[i][j] = input[i][current];
                    current++;
                }
            }
        }
        return returnArray;
    }

    void removeEntry(int[][] input, int col){
        for (int i = 0; i < input.length; i++) {
            int[] copyArray = input[i];
            if (input[i].length-1 >= col){
                if (input[i].length > 0){
                    input[i] = new int[copyArray.length-1];
                    int x = 0;
                    for (int j = 0; j < copyArray.length; j++) {
                        if (j != col){
                            input[i][x] = copyArray[j];
                            x++;
                        }
                    }
                }
            }
        }
    }

    boolean isAlternating(int[] seq, int index){
        if (seq.length-1 == index){
            return true;
        }
        if (index == seq.length - 2){
            return seq[index] * seq[index+1] < 0;
        }
        if (seq[index] * seq[index+1] > 0){
            return false;
        }
        return isAlternating(seq, index+1);
    }
    static void main(String[] args) {
        Day9 d = new Day9();

        int[][] test1 = {{5}, {5, 7, 9}, {8, 5}, {}};
        int[][] test2 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        int[][] test3 = {{}, {1, 2, 3, 4}, {1}};
        int[] seq = {1, 2, -5, 3, -1, 6, -3, 3};

        System.out.println("vorgegebene Testfälle");
        System.out.println("_______________________________________________");

        System.out.println("result1 = getRectangular(test1)");
        int[][] result1 = d.getRectangular(test1);
        System.out.println(Arrays.deepToString(result1));
        System.out.println("_______________________________________________");

        System.out.println("result2 = getRectangular(test2)");
        int[][] result2 = d.getRectangular(test2);
        System.out.println(Arrays.deepToString(result2));
        System.out.println("_______________________________________________");

        System.out.println("result3 = getRectangular(test3)");
        int[][] result3 = d.getRectangular(test3);
        System.out.println(Arrays.deepToString(result3));
        System.out.println("_______________________________________________");

        System.out.println("result4 = getRectangular(new int[][]{{}})");
        int[][] result4 = d.getRectangular(new int[][]{{}});
        System.out.println(Arrays.deepToString(result4));
        System.out.println("_______________________________________________");

        System.out.println("removeEntry(test2, 2)");
        d.removeEntry(test2, 2);
        System.out.println(Arrays.deepToString(test2));
        System.out.println("_______________________________________________");

        System.out.println("removeEntry(test3, 0)");
        d.removeEntry(test3, 0);
        System.out.println(Arrays.deepToString(test3));
        System.out.println("_______________________________________________");

        System.out.println("isAlternating(seq, 0)");
        System.out.println(d.isAlternating(seq, 0));
        System.out.println("_______________________________________________");

        System.out.println("isAlternating(seq, 1)");
        System.out.println(d.isAlternating(seq, 1));
        System.out.println("_______________________________________________");

        System.out.println("isAlternating(seq, 6)");
        System.out.println(d.isAlternating(seq, 6));
        System.out.println("_______________________________________________");

        System.out.println("isAlternating(seq, 7)");
        System.out.println(d.isAlternating(seq, 7));
        System.out.println("_______________________________________________");

    }
}
