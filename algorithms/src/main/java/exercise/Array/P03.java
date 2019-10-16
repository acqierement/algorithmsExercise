package src.main.java.exercise.Array;

import java.util.Arrays;

/**
 * Majority Element（求众数）
 * 使用排序，分治法
 */
public class P03 {
    // 用排序，太暴力了
    public int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    // 分治法
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int majorityElementRec(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (end - start) / 2 + start;
        int leftMajorityNum = majorityElementRec(nums, start, mid);
        int rightMajorityNum = majorityElementRec(nums, mid + 1, end);

        if (leftMajorityNum == rightMajorityNum) return leftMajorityNum;

        int leftCount = countInRange(leftMajorityNum, nums, start, mid);
        int rightCount = countInRange(rightMajorityNum, nums, mid + 1, end);

        return leftCount > rightCount ? leftMajorityNum : rightMajorityNum;
    }

    public int countInRange(int num, int[] nums, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
