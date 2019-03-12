import java.util.Arrays;

public class Math01 {
    public boolean splitArraySameAverage(int[] A) {
        int n = A.length, sum = Arrays.stream(A).sum();
        for (int i = 1; i <= n / 2; ++i) {
            if (sum * i % n == 0 && find(A, sum * i / n, i, 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param A 输入的数组
     * @param target 目标和
     * @param count 需要几个数
     * @param index 数组的索引，记录当前到数组的哪个位置了。
     * @return
     */
    public boolean find(int[] A, int target, int count, int index) {
        if (count == 0) return target == 0;
        // 剩下的数量小于count，直接返回false
        if (count + index > A.length) return false;
        // 递归调用，分别判断加入当前这个数或不加入这个数的情况。
        return find(A, target - A[index], count - 1, index + 1) || find(A, target, count, index + 1);
    }
}
