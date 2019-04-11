public class BinarySearch01 {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int ans = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (mid <= x / mid) {
                low = mid + 1;
                // 保存答案，等于的情况也需要进入这里，才可以得到答案
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

}
