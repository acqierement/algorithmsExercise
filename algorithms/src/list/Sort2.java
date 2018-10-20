package sort;
/**
 * 归并排序和快排
 * @author xu
 *
 */
public class Sort2 {
	//归并排序
	public void mergeSort(int[] a) {
		int len = a.length;
		sortByMerge(a, 0, len-1);
	}
	
	//快速排序
	public void quickSort(int[] a) {
		int len = a.length;
		sort_quick(a,0,len - 1);
	}
	
	private void sort_quick(int[] a, int left, int right) {
		if(left >= right) return;
		int point = partition(a,left,right);
		sort_quick(a, left, point-1);
		sort_quick(a, point+1, right);
	}
	private int partition(int[] a, int i, int j) {
		int pivot = a[j];//取最右边的为基准点。
		int left = i;
		int right = j;
		while(left < right) {
				while(left < right && a[left] <= pivot) left++;
				if(left<right) a[right] = a[left];
				while(left < right && a[right] >= pivot) right--;
				if(left < right) a[left] = a[right];
		}
		a[left] = pivot;
		return left;
	}
	private void sortByMerge(int[] a, int low, int high) {
		int mid = (low + high)/2;
		if(low<high) {
			sortByMerge(a, low, mid);
			sortByMerge(a, mid+1, high);
			merge(a, low, mid, high);
		}
	}
	private void merge(int[] a, int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		int t = 0;
		int[] temp = new int[high - low + 1];
		while(left <= mid && right <= high) {
			if(a[left] <= a[right]) {
				temp[t++] = a[left++];
			}else {
				temp[t++] = a[right++];
			}
		}
		while(left <= mid) {
			temp[t++] = a[left++];
		}
		while(right <= high) {
			temp[t++] = a[right++];
		}
		for(int i = 0; i < temp.length; i++)
			a[i+low] = temp[i];
	}
	
}
