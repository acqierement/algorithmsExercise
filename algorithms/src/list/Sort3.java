package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序，计数排序，基数排序
 * @author xu
 *
 */
public class Sort3 {
	public void bucketSort(int[] a) {
		//这里桶的数量定好了
		int bucketNums = 5;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			max = a[i] > max ? a[i] : max;
			min = a[i] <min ? a[i] : min;
		}
		List<List<Integer>> bucketList = new ArrayList<>();
		for (int i = 0; i < bucketNums; i++) {
			bucketList.add(new ArrayList<>());
		}

		for (int i = 0; i < a.length; i++) {
			int index = (int) ((a[i] - min)/((max - min +1.0)/bucketNums));
			bucketList.get(index).add(a[i]);
		}

		for (List<Integer> list : bucketList) {
			Collections.sort(list);
		}
		int cur = 0;
		for (List<Integer> list : bucketList) {
			for (Integer num : list) {
				a[cur++] = num;
			}
		}
	}
	
	public void countingSort(int[] a) {
		int bucketNums = 11;
		int[] count = new int[bucketNums];
		for(int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}

		for (int i = 0; i < count.length-1; i++) {
			count[i+1] = count[i]+count[i+1];
		}

		int[] temp = new int[a.length];
		for (int i = temp.length - 1; i >= 0; i--) {
			int index = count[a[i]]-1;
			temp[index] = a[i];
			count[a[i]]--;
		}
		
		for (int i = 0; i < temp.length; i++) {
			a[i] = temp[i];
		}
	}
	
	public void radixSort(int[] a,int numLen) {
		int n = 1;//1,10,100...
		int len = a.length;
		int bits = (int) Math.pow(10, numLen);//两位数就是100，三位数就是100
		int[][] buckets = new int[10][len];
		int[] count = new int[len];
		while(n<bits) {
			for (int i = 0; i < a.length; i++) {
				int digit = a[i]/n%10;
				buckets[digit][count[digit]] = a[i];
				count[digit]++;
			}
			int curArr = 0;
			for (int curBucket = 0; curBucket <= 9; curBucket++) {
				if(buckets[curBucket][0]!=0) {
					for (int index = 0; index < count[curBucket]; index++) {
						a[curArr++] = buckets[curBucket][index];
					}
				}
				count[curBucket] = 0;
			}
			n *=10;
		}
		
	}
}
