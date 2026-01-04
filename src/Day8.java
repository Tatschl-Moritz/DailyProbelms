import java.util.Arrays;
import java.util.Objects;

public class Day8 {
    int[][] countdown(int[][] rules){
        int [][] returnArray = new int[rules.length][];


        for (int i = 0; i < rules.length; i++) {
            int l = 0;
            int startWert = rules[i][2];
            int endWert = rules[i][0];
            int minusWert = rules[i][1];
            for (int j = startWert; j >= endWert; j -= minusWert) {
                l++;
            }
            returnArray[i] = new int[l];

            int current = 0;
            for (int j = startWert; j >= endWert; j -= minusWert) {
                returnArray[i][current] = startWert;
                startWert -= minusWert;
                current++;
            }
        }
        return returnArray;
    }

    void extract(String[][] info, int[] positions){
        int x = 0;
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                boolean matcht = false;
                String current = info[i][j];
                if (current.length()== 4 && current.charAt(0) == 'S' && current.charAt(1) == 'S' && current.charAt(2) == '2' && current.charAt(3) == '1'){
                    matcht = true;
                }
                if (matcht && x + 2 <= positions.length){
                    positions[x] = i;
                    positions[x+1]= j;
                    x = x+2;
                }
            }
        }
        if (x != positions.length){
            for (int i = x; i < positions.length; i++) {
                positions[x] = -21;
                x++;
            }
        }
    }

    boolean backAndForth(String csequence){
        if (csequence.length() == 2) {
            return csequence.charAt(0) != csequence.charAt(1);
        }

        char a = csequence.charAt(0);
        char b = csequence.charAt(1);
        char c = csequence.charAt(2);

        if (a == b || a != c){
            return false;
        }
        return backAndForth(csequence.substring(1));
    }

    static void main(String[] args) {
        Day8 d = new Day8();

        int[][] pattern1 = { {0, 4, 16}, {1, 2, 10}, {4, 4, 7} };
        int[][] pattern2 = { {5, 22, 50}, {5, 2, 11}, {4, 2, 11}, {-2, 3, 10} };
        String[][] sem1 = {"WS20;SS21;WS21".split(";"), "SS21;gut;versteckt".split(";"), "SS21a;SS21;SS 21".split(";")};
        String[][] sem2 = {"last;test;in;SS21".split(";"), "SS21;endet;SS21".split(";"), "#TU;#;SS21;#Covid".split(";")};
        String[][] sem3 = {"nicht;versteckt".split(";"), {"SS21"}, "nur;ein;Text".split(";")};
        int[] ss21pos = new int[2 * sem1.length];

        System.out.println("vorgegeben Testfälle: ");
        System.out.println("_______________________________________________");

        System.out.println("result1 = countdown(pattern1)");
        int[][] result1 = d.countdown(pattern1);
        System.out.println(Arrays.deepToString(result1));
        System.out.println("_______________________________________________");

        System.out.println("result2 = countdown(pattern2)");
        int[][] result2 = d.countdown(pattern2);
        System.out.println(Arrays.deepToString(result2));
        System.out.println("_______________________________________________");

        System.out.println("result3 = countdown(new int[][]{{4, 4, 8}, {5, 4, 8}})");
        int[][] result3 = d.countdown(new int[][]{{4, 4, 8}, {5, 4, 8}});
        System.out.println(Arrays.deepToString(result3));
        System.out.println("_______________________________________________");


        System.out.println("extract(sem1, ss21pos)");
        d.extract(sem1, ss21pos);
        System.out.println(Arrays.toString(ss21pos));
        System.out.println("_______________________________________________");

        System.out.println("extract(sem2, ss21pos)");
        d.extract(sem2, ss21pos);
        System.out.println(Arrays.toString(ss21pos));
        System.out.println("_______________________________________________");

        System.out.println("extract(sem3, ss21pos)");
        d.extract(sem3, ss21pos);
        System.out.println(Arrays.toString(ss21pos));
        System.out.println("_______________________________________________");

        System.out.println("backAndForth(\"s2sss2s\")");
        System.out.println(d.backAndForth("s2sss2s"));
        System.out.println("_______________________________________________");

        System.out.println("backAndForth(\"2s212s2\")");
        System.out.println(d.backAndForth("2s212s2"));
        System.out.println("_______________________________________________");

        System.out.println("backAndForth(\"ss\")");
        System.out.println(d.backAndForth("ss"));
        System.out.println("_______________________________________________");

        System.out.println("backAndForth(\"2020202\")");
        System.out.println(d.backAndForth("2020202"));
        System.out.println("_______________________________________________");

        System.out.println("backAndForth(\"s2s2s2s2\")");
        System.out.println(d.backAndForth("s2s2s2s2"));
        System.out.println("_______________________________________________");

    }
}
