package src.main.java.exercise.DivideAndConquer;

public class DivideAndConquer01 {
    private int count = 0;

    public int InversePairs(int[] array) {
        merge(array, 0, array.length - 1);
        return count;
    }

    public void merge(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = (end - start) / 2 + start;
        merge(array, start, mid);
        merge(array, mid + 1, end);
        doMerge(array, start, mid, end);
    }
    // 左右两部分都是有序的
    private void doMerge(int[] array, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int index = 0;
        int[] temp = new int[end - start + 1];
        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) {
                temp[index++] = array[left++];
            } else { // array[left] > array[right],left 右边的数也都大于right，所以一共有mid - left + 1个逆序对
                temp[index++] = array[right++];
                count += mid - left + 1;
            }
        }
        while(left <= mid) temp[index++] = array[left++];
        while(right <= end) temp[index++] = array[right++];

        for(int i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }
}
