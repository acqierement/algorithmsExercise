import java.util.Arrays;

public class DynamicProgramming04 {
    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[amount + 1];
        return helper(coins, amount, counts);

    }

    private int helper(int[] coins, int amount, int[] counts) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (counts[amount] != 0) return counts[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, amount - coin, counts);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        counts[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return counts[amount];
    }

    // 第二种方法，先进行排序
    private int res = Integer.MAX_VALUE;

    public int coinChange01(int[] coins, int amount) {
        Arrays.sort(coins);
        count(coins, coins.length - 1, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private void count(int[] coins, int index, int amount, int count) {
        if (index < 0) return;
        int k = amount / coins[index];
        for (int i = k; i >= 0; i--) {
            int newCount = count + i;
            int rem = amount - i * coins[index];
            if (rem > 0 && newCount < res) {
                count(coins, index - 1, rem, newCount);
            } else if (rem == 0 && newCount < res) {
                // 原本使用min，没有下一个else if里的break，结果超时了。
                // res = Math.min(newCount, res)
                res = newCount;
            } else if (newCount > res) {// 现在数量超过最小值了，再往后使用更多数值小的硬币，数量就更加多了，所以没必要进行下去了
                break;
            }
        }
    }
}
