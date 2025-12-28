//leetcode problem: 1. Two Sum

public class Day1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ausgabe = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    ausgabe[0]=i;
                    ausgabe[1]=j;
                    return ausgabe;
                }
            }
        }
        return null;
    }
}
