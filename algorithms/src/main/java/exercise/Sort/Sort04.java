
public class Sort04 {
    public void mergeSort(int nums[]) {
        sortByMerge(nums, 0, nums.length - 1);
    }

    private void sortByMerge(int[] nums, int low, int high) {
        if (low == high) return;
        int mid = (high - low) / 2 + low;
        sortByMerge(nums, low, mid);
        sortByMerge(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid + 1;
        int temp[] = new int[high - low + 1];
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= high) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= high) {
            temp[tempIndex++] = nums[rightIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}
