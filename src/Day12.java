import java.util.Arrays;

public class Day12 {
    static boolean[][] create(int[] input){
        boolean[][] returnArray = new boolean[input.length][];
        for (int i = 0; i < input.length; i++) {
            if (input[i] >= 3){
                returnArray[i]= new boolean[input[i]+1];
            }else {
                returnArray[i]= new boolean[3];
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0){
                continue;
            }else {
                returnArray[i][input[i]] = true;
            }
        }
        return returnArray;
    }

    static void move(int[][] input){
        for (int i = 0; i < input.length; i++) {
            int letztesElement = input[i][input[i].length-1];
            if (letztesElement != 0){
                //[1][2][3][4][5][6][7]
                int[] copy = input[i];
                input[i] = new int[copy.length+1];

                for (int j = 0; j < copy.length; j++) {
                    input[i][j+1] = copy[j];
                }
                input[i][0] = 0;
            }else {
                int[] copy = input[i];
                for (int j = copy.length-2; j >= 0; j--) {
                    input[i][j+1] = copy[j];
                }
                input[i][0] = 0;
            }
        }
    }
    static void main(String[] args) {
        int[] test1 = {3, 0, 6, -1, 1};
        int[][] test2 = {{0}, {6, -5}, {0, 0}, {0, 1, 2, 0}};
        int[][] test3 = {{1, 2, 7, 3, 0}, {-8}, {0, 2}, {1, 4, -2, 1}};

        System.out.println("_______________________________________________");
        System.out.println("result1 = create(new int[]{3})");
        boolean[][] result1 = create(new int[]{3});
        System.out.println(Arrays.deepToString(result1));

        System.out.println("_______________________________________________");
        System.out.println("result2 = create(new int[]{-2, 0})");
        boolean[][] result2 = create(new int[]{-2, 0});
        System.out.println(Arrays.deepToString(result2));

        System.out.println("_______________________________________________");
        System.out.println("result3 = create(new int[]{})");
        boolean[][] result3 = create(new int[]{});
        System.out.println(Arrays.deepToString(result3));

        System.out.println("_______________________________________________");
        System.out.println("move(test2)");
        move(test2);
        System.out.println(Arrays.deepToString(test2));

        System.out.println("_______________________________________________");
        System.out.println("move(test3)");
        move(test3);
        System.out.println(Arrays.deepToString(test3));
    }
}
