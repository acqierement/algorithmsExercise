/**
 * 插入排序
 */
/**
 * 二维数组的查找
 *
 * @author acqierement Data: 2018年11月17日 Time: 下午6:31:40
 *
 *
 * 原本我的想法也是和书里前面说的一样，从矩阵的右下角开始，发现这样最后要找的数在i行i列，
 * 然后还要遍历i行和i列，而且矩形也不一定是正方形。所以总的来说和书中介绍的用右上角或左下角没有太大区别，用书上的方法还比较直观。
 * 以上都是我在挣扎过后得出的教训，结论就是还是书上的方法好啊
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
