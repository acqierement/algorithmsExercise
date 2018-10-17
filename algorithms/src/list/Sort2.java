package sort;

public class Sort2 {

	public void mergeSort(int[] a) {
		int len = a.length;
		sort(a, 0, len-1);
	}
	
	private void sort(int[] a, int low, int high) {
		int mid = (low + high)/2;
		if(low<high) {
			sort(a, low, mid);
			sort(a, mid+1, high);
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
