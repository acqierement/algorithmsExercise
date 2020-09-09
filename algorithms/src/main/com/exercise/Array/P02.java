package com.exercise.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P02 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        threeSum(nums);
    }

    /**
     * 先对数组排序，简化逻辑。由于结果不能有重复，比如-1,-1,0,1这个数组，只能有一个[-1,0,1],不能出现两个。
     * 所以排序后的数组要跳过重复的数字。跳过重复的数字比较麻烦，要考虑挺多的。
     * 写一下自己是怎么犯错的：
     * 首先如果是[-1,-1,0,1,2]，这里有两个-1，考虑的[-1,0,-1]只能出现一个，所以想要去掉一个-1，所以想让第一个指针
     * 从第二个-1开始，那么数组变成了[-1,0,1,2]这样就不会有两个[-1,0,-1]答案出现了。但是原本的数组有个答案是[-1,-1,2]
     * 这样做的话就得不到这个答案了。所以不可以这么做。我们要让指针从重复序列的第一个数字开始。所以第一个指针第一个应该指向
     * [-1,-1,0,1,2].第二次直接指向下一个不重复的数字[0,1,2]
     * 具体的做法就是while(nums[i] != nums[i-1]) do something 否则 i++，注意和nums[i] != nums[i+1]区别。
     * 前者是指向重复序列的第一个数字，跳过其余数字；后者是指向重复序列的最后一个数字，跳过其余数字
     * <p>
     * 还有一个出错的地方。前面处理好了，后面还有两个数字需要确定，我想先去重再判断答案。还用前面的方法来进行去重
     * 但是发现不管取第一个还是最后一个都不行：
     * [-1,-1,2] 如果我们取第一个，就是while(nums[l] == nums[l-1]) l++。当我们的i指向第一个数字，这时l会指向第二个数，
     * 然后进行判断while(nums[l] == nums[l-1])，会执行l++，直接跳过-1到达2，得不到答案
     * <p>
     * 如果我们取最后一个，那么对于[-2,1,1],第二个数跳过第一个1，到达第二个1.也不会得到正确的答案。
     * <p>
     * 所以要先判断答案再去重，如果是正确答案，就移动左右指针并去重，
     * 如果不是正确答案，由于我们排过序了，所以只需移动单边指针，并可以进行去重，但是我发现这时去重在LeetCode速度反而变慢
     *
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        for (int i = 0; i < nums.length - 2; i++) {
            //注意nums[i] != nums[i-1]和nums[i] != nums[i+1]的区别
            // 我这里加了一个nums[i] <= 0判断，
            //如果第一个数大于零，那么后面的数也会大于零，不需要判断
            if (i == 0 || (nums[i] != nums[i - 1] && nums[i] <= 0)) {
                int l = i + 1, r = nums.length - 1;
                while (r > l) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (r > l && nums[l] == nums[l + 1]) l++;
                        while (r > l && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum > 0) {
                        //这里如果去重反而速度下降，不知道为什么
                        // while (r > l && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else {
                        // while (r > l && nums[l] == nums[l + 1]) l++;
                        l++;
                    }
                }
            }

        }
        return res;
    }
}
