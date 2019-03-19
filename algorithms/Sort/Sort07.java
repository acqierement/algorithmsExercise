import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Sort07 {

    public static void sort(int[] array) {
//        Executors.newCachedThreadPool()
        int n = array.length;
        buildHeap(array, n);
        int k = n;
        while(k > 0) {
            swap(array, 0, k - 1);
            k--;
            heapify(array, k, 1);
        }
    }

    // 注意这里传入的i最小是1，表示第一个数据，在数组中的索引是0
    // n/2 的位置表示第一个有子树的节点
    private static void  buildHeap(int[] array, int n){
        for (int i = n / 2; i >= 1; i--) {
            heapify(array, n, i);
        }
    }

    // heapify方法默认左右子树都是正确的堆
    private static void heapify(int[] array, int n, int i) {
        int left = i * 2 - 1;
        int right = left + 1;
        int maxPos = i - 1;
        if (left < n && array[left] > array[i - 1]) {
            maxPos = left;
        }
        if (right < n && array[right] > array[maxPos]) {
            maxPos = right;
        }

        if(maxPos == i - 1) return;
        swap(array, maxPos, i - 1);
        heapify(array, n, maxPos + 1);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
