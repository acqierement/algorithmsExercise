package list;


/**
 * bubble Sort,Selection Sort,Insertion Sort. 
 * 这几个排序算法的时间复杂度都是O(n^2)
 * 默认从小到大排序
 * @author xu
 *
 */
public class Sort1 {
	
	//时间复杂度O(n^2),空间复杂度O(1),稳定排序
	public void buttleSort(int[] nums) {
		int len = nums.length;
		if(len <= 1) return;
		for (int i = 0; i < len; i++) {
			boolean isSwap = false;
			for (int j = 0; j < len-i-1; j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					isSwap = true;
				}
			}
			if(!isSwap) break;
		}
	}
	
	//时间复杂度O(n^2),空间复杂度O(1),不稳定排序
	public void selectionSort(int[] nums) {
		int len = nums.length;
		if(len <= 1) return;
		int minIndex = 0;
		for (int i = 0; i < len; i++) {
			minIndex = i;
			for(int j = i+1; j < len; j++) {
				if(nums[j]<nums[minIndex]) {
					minIndex = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
	}
	
	//时间复杂度O(n^2),空间复杂度O(1),稳定排序
	public void insertionSort(int[] nums) {
		int len = nums.length;
		if(len <= 1) return;
		for(int i = 1; i < len; i++) {
			int value = nums[i];
			int prev = i-1;
			while(prev >=0 && nums[prev] > value) {
				nums[prev + 1] = nums[prev];
				prev--;
			}
			nums[prev + 1] = value;
		}
	}
}
