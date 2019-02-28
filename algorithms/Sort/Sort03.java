/**
 * 插入排序
 */
public class Sort03 {
    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            int index = i - 1;
            while (index >= 0 && curNum < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = curNum;
        }
    }


}
