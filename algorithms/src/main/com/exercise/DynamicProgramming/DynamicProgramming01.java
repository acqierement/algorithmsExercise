package com.exercise.DynamicProgramming;

/**
 * 0-1背包问题：每个物品有对应的价值和重量，在限定重量下选出最有价值的物品。
 */
public class DynamicProgramming01 {
    public static int knapsack(int[] value, int[] weight, int capacity) {
        int count = value.length;
        int[][] temp = new int[count + 1][capacity + 1];
        // 初始化（第一行第一列为零）
        for (int i = 0; i <= count; i++) {
            temp[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            temp[0][i] = 0;
        }


        for (int index = 1; index <= count; index++) { // index表示当前是第几个物品
            for (int curC = 1; curC <= capacity; curC++) { // curC 表示当前容量
                if (weight[index - 1] > curC) { // 当前物体大于当前的容量
                    temp[index][curC] = temp[index - 1][curC]; // 由于当前物体放不进来，所以最大值和前一个相同
                } else {
                    // 判断不加这个物品和加入这个物品，哪个价值最大。不加物品式子和前面一样
                    // 加入这个物品就要判断加入这个物品之后的最大值。假设当前容量是8，这个物品是5，
                    // 我们要找到8-5=3，容量是3的时候的最大值加上当前物品的价值，就是我们要加入这个物品后的最大值
                    temp[index][curC] = Math.max(temp[index - 1][curC],
                            temp[index - 1][curC - weight[index - 1]] + value[index - 1]);
                }
            }
        }
        return temp[count][capacity];
    }

    public static void main(String[] args) {
//        int[] value = {3, 4, 5, 6};
//        int[] weight = {2, 3, 4, 5};
        int[] value = {3};
        int[] weight = {2};
        int maxValue = knapsack(value, weight, 2);
        System.out.println(maxValue);
    }
}
