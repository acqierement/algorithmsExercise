package com.exercise.Sort;

/**
 * 快排
 */
public class Sort05 {
    public void quickSort(int[] nums) {
        sort_quick(nums, 0, nums.length - 1);
    }

    private void sort_quick(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivotIndex = partition(nums, left, right);
        sort_quick(nums, left, pivotIndex - 1);
        sort_quick(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        while (left < right) {
            while (left < right && nums[left] < pivot) left++;
            if (left < right) nums[right] = nums[left];
            while (left < right && nums[right] >= pivot) right--;
            if (left < right) nums[left] = nums[right];
        }
        //left == right
        nums[left] = pivot;
        return left;
    }
}
