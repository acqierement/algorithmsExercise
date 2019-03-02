public class Sort06 {
    public int findTopK(int nums[], int k){
        return findTopK(nums, 0, nums.length - 1, k);
    }

    private int findTopK(int[] nums, int left, int right, int k) {
        if(nums.length < k) {
            return -1;
        }
        int pivotIndex = partition(nums, left, right);
        if(pivotIndex + 1 > k) {
            findTopK(nums, left, pivotIndex - 1, k);
        }else if(pivotIndex + 1 < k) {
            findTopK(nums, pivotIndex + 1, right, k);
        }

        return nums[k - 1];

    }

    private int partition(int[] nums, int left, int right) {
        int pivotValue = nums[right];
        while(left < right) {
            while (left < right && pivotValue <= nums[left]) left++;
            if (left < right) nums[right--] = nums[left];
            while (left < right && pivotValue >= nums[right]) right--;
            if (left < right) nums[left++] = nums[right];
        }
        nums[left] = pivotValue;
        return left;
    }
}
