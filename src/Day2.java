//leetcode problem: 2. Add Two Numbers

//I did not see that it is not with arrays it was with lists still gonna upload this cause it works and is practice

import java.util.Arrays;

public class Day2 {

    public static int[] addTwoNumbers(int[] l1, int[] l2) {
        int modulo = 0;

        int x = Math.min(l1.length, l2.length);
        int y = Math.max(l1.length, l2.length);
        int[] output = new int[y+1];

        for (int i = 0; i < x; i++) {
            int result = l1[i]+l2[i]+modulo;

            output[i] = result % 10;
            modulo = result / 10;
        }
        for (int i = x; i < y; i++) {
            int result = 0;
            if (l1.length > l2.length){
                result = l1[i]+modulo;
            }else {
                result = l2[i]+modulo;
            }
            output[i] = result % 10;
            modulo = result / 10;
        }
        output[y] = modulo;

        if (modulo == 0) {
            return Arrays.copyOf(output, y);
        }
        return output;
    }

    static void main() {
        int[] l1 = {2,4,3};
        int[] l2 = {5,6,4};
        System.out.println(Arrays.toString(addTwoNumbers(l1, l2)));

        int[] l3 = {9,9,9,9,9,9,9};
        int[] l4 = {9,9,9,9};
        System.out.println(Arrays.toString(addTwoNumbers(l3, l4)));
    }
}
