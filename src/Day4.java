//First semester Programing test practice check in pdfs Probetest_WS25


import java.util.Arrays;

public class Day4 {
    int[][] generate(int[][] input) {
        //Array mit gleicher strucktur erstellen
        int[][] returnArray = new int[input.length][];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = new int[input[i].length];
        }
        // wisen wieviel pos und neg werte wir haben damit mann das array befüllen kann


        for (int i = 0; i < returnArray.length; i++) {
            int neg = 0;
            // zehlen wieviele neg werte mann hat
            for (int j = 0; j < returnArray[i].length; j++) {
                if (input[i][j] < 0) {
                    neg++;
                }
            }

            int startNeg = 0;
            int startPos = startNeg + neg;
            for (int j = 0; j < returnArray[i].length; j++) {
                if (input[i][j] >= 0) {
                    returnArray[i][startPos]= input[i][j];
                    startPos++;
                }

                if (input[i][j] < 0) {
                    returnArray[i][startNeg]= input[i][j];
                    startNeg++;
                }
            }
        }
        return returnArray;
    }

    void fill(int[][] target, int[] values, int[] times){
        int x = 0;
        int current = 0;

        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if(x >= times[current]){
                    current++;
                    x = 0;
                }
                target[i][j]= values[current];
                x++;
            }
        }
    }

    String extractString(char[] sequence, int start, int end, char omit){
        if (start == end){
            return "";
        }
        if (sequence[start] == omit){
            return extractString(sequence,start+1,end,omit);

        }
        if (sequence[start] != omit){
            return sequence[start] + extractString(sequence,start+1,end,omit);

        }
        return "";
    }




    public static void main(String[] args) {
        Day4 d = new Day4();

        int[][] test1 = { {1, 2, 0, -1, -2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5, -1} };
        int[][] test2 = { {1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4} };
        int[][] test3 = { {1, -1, 2, -2, 3}, {1, 2, 3}, {-3, -1, -2} };
        char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
        char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};

        System.out.println("vorgegebene Testfälle");

        System.out.println("result1 = generate(test1)");
        int[][] result1 = d.generate(test1);
        System.out.println(Arrays.deepToString(result1));

        System.out.println("result2 = generate(test2)");
        int[][] result2 = d.generate(test2);
        System.out.println(Arrays.deepToString(result2));

        System.out.println("fill(test3, test2[0], test2[1])");
        d.fill(test3, test2[0], test2[1]);
        System.out.println(Arrays.deepToString(test3));

        System.out.println("fill(test1, test2[3], test2[4])");
        d.fill(test1, test2[3], test2[4]);
        System.out.println(Arrays.deepToString(test1));

        System.out.println("fill(result1, test2[2], test2[4])");
        d.fill(result1, test2[2], test2[4]);
        System.out.println(Arrays.deepToString(result1));

        System.out.println("fill(test3, test2[2], test2[3])");
        d.fill(test3, test2[2], test2[3]);
        System.out.println(Arrays.deepToString(test3));

        System.out.println("extractString(age1, 0, age1.length, '-')");
        System.out.println(d.extractString(age1, 0, age1.length, '-'));

        System.out.println("extractString(age1, 1, 7, 'u')");
        System.out.println(d.extractString(age1, 1, 7, 'u'));

        System.out.println("extractString(age2, 0, 5, 'a')");
        System.out.println(d.extractString(age2, 0, 5, 'a'));

        System.out.println("extractString(age2, 5, age2.length, 'n')");
        System.out.println(d.extractString(age2, 5, age2.length, 'n'));
    }
}
