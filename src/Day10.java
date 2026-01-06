//First semester Programing test practice check in pdfs Probetest_WS25

import java.util.Arrays;

public class Day10 {

    static int[][] addTriangle(int[][] input){
        int[][] returnArray = new int[input[0].length+ input.length][];
        for (int i = 0; i < input[0].length; i++) {
            returnArray[i]= new int[i+1];
        }
        int current = 0;
        for (int i = input[0].length; i < returnArray.length; i++) {
            returnArray[i]= new int[input[current].length];
            current++;
        }
        // array befullen
        int x = 1;
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < returnArray[i].length; j++) {
                returnArray[i][j] = x;
            }
            x++;
        }
        current = 0;
        for (int i = input[0].length; i < returnArray.length; i++) {
            for (int j = 0; j < returnArray[i].length; j++) {
                returnArray[i][j] = input[current][j];
            }
            current++;
        }
        return returnArray;
    }

    static void reverseBetween(int[][] input, int ind1, int ind2){
        int current = 0;
        int start = 0;
        int end = 0;
        if (ind1 > ind2){
            start = ind2;
            end = ind1;
        }else {
            start = ind1;
            end = ind2;
        }
        int x = 0;
        int y = start;
        for (int i = start; i < end; i = i + 2) {
            int[] helpArray = input[y];
            input[y] = input[end -x];
            input[end-x] = helpArray;
            x++;
            y++;
        }
    }

    static String clean(String seq){
        if (seq.isEmpty()){
            return "";
        }
        if (seq.charAt(0) == '(' && seq.charAt(seq.length()-1) == ')'){
            return seq.substring(1,seq.length()-1);
        }

        int rechts = seq.length()-2;
        int links = 1;
        if (seq.charAt(0) == '('){
            links = 0;
        }
        if (seq.charAt(seq.length()-1) == ')'){
            return clean(seq.substring(links));
        }
        return clean(seq.substring(links,rechts));

    }

    static void main(String[] args) {
        int[][] test1 = {{5, 7, 5, 7}, {5}, {0, 1, 1, 0}};
        int[][] test2 = {{5, 7, 9}, {5}, {8, 5}, {2}, {3}};
        int[][] testselber = {{5, 7, 9}, {5}, {8, 5},{1,2,3}, {2}, {3}};
        int[][] test3 = {{1, 2}, {1, 2, 3}, {}};
        String seq = "1(234)67";

        System.out.println("vorgegeben Testfälle");
        System.out.println("_______________________________________________");

        System.out.println("result1 = addTriangle(test1)");
        int[][] result1 = addTriangle(test1);
        System.out.println(Arrays.deepToString(result1));
        System.out.println("_______________________________________________");

        System.out.println("result2 = addTriangle(test2)");
        int[][] result2 = addTriangle(test2);
        System.out.println(Arrays.deepToString(result2));
        System.out.println("_______________________________________________");

        System.out.println("reverseBetween(test1, 2, 1)");
        reverseBetween(test1, 2, 1);
        System.out.println(Arrays.deepToString(test1));
        System.out.println("_______________________________________________");

        System.out.println("reverseBetween(test2, 1, 4)");
        reverseBetween(test2, 1, 4);
        System.out.println(Arrays.deepToString(test2));
        System.out.println("_______________________________________________");

        System.out.println("reverseBetween(testselber, 1, 4)");
        reverseBetween(testselber, 1, 5);
        System.out.println(Arrays.deepToString(testselber));
        System.out.println("_______________________________________________");

        System.out.println("reverseBetween(test3, 2, 2)");
        reverseBetween(test3, 2, 2);
        System.out.println(Arrays.deepToString(test3));
        System.out.println("_______________________________________________");

        System.out.println("reverseBetween(test3, 0, 2)");
        reverseBetween(test3, 0, 2);
        System.out.println(Arrays.deepToString(test3));
        System.out.println("_______________________________________________");

        System.out.println("clean(seq)");
        System.out.println(clean(seq));
        System.out.println("_______________________________________________");

        System.out.println("clean(\"123(45))\")");
        System.out.println(clean("123(45))"));
        System.out.println("_______________________________________________");

        System.out.println("clean(\"x)\")");
        System.out.println(clean("x)"));
        System.out.println("_______________________________________________");

        System.out.println("clean(\")x(\")");
        System.out.println(clean(")x("));
        System.out.println("_______________________________________________");



    }
}
