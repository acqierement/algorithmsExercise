## 数学相关问题

1. 判断能否把一个数组分成平均值相同的两部分（\[1,2,3\]可以分成\[1 3\]和\[2]，平均值都是2）LeetCode[805. Split Array With Same Average](https://leetcode.com/problems/split-array-with-same-average/)
    
### 判断能否把一个数组分成平均值相同的两部分
数组的总和totalSum，数组个数n，我们拆分的两个数组叫做A和B,我们可以得到这个等式。
totalSum/n = Asum/Acount = Bsum/(n - Acount)
根据前一个等式可以得到：
Asum = totalSum * Acount / n

数组总和totalSum我们可以得到，个数n也知道了。
A部分的数量Acount从1到n/2,根据公式可以得到Asum的一系列值。
接下去问题就变成了判断可不可以从数组里面找出Acount个数的和等于Asum
由于Asum是整数，所以我们可以用totalSum * Acount % n == 0当做前提条件，先满足了这个条件然后再去判断和的问题


