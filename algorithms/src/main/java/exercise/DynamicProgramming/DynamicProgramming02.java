package src.main.java.exercise.DynamicProgramming;

/**
 * 打家劫舍
 */
public class DynamicProgramming02 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            sum[i] = Math.max(nums[i - 1] + sum[i - 2], sum[i - 1]);
        }
        return sum[nums.length];
    }
}
