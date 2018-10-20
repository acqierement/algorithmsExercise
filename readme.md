# algorithmsDemo

用来记录一下学习算法的一些练习。

## 目录

- [单链表判断是否是回文](#单链表判断是否是回文)
- [关于链表的一些练习](#关于链表的一些练习)
- [排序算法1-O(n^2)](#排序算法1)
- [排序算法2-归并和快排](#排序算法2-归并和快排)

<h2 id="单链表判断是否是回文" >单链表判断是否是回文</h2>

可以参考LeetCode的234题[palindrome-linked-list](https://leetcode.com/problems/palindrome-linked-list/)。回文就是从左到右和从右到左都是一样的，比如123321,45654.

第一种方法：isPalindromeByReverse()。就是把链表逆序排列，再和原来的链表相比较是不是完全一样。由于逆序会破坏原来链表的顺序，所以先copy一份。

第二种方法：isPalindromeByFindCenter()。就是先找到链表的中点，然后判断中点的左右部分是否关于中点对称。如何快速找到中点呢？就用快慢指针的方法，慢指针每次前进一步，快指针每次前进两步，这样当快指针走到末尾的时候，慢指针就到了中点。由于是单链表，即使找到了中点，要向两边遍历也比较麻烦，所以先将中点后面的链表逆序，然后判断前半部分和逆序后的后半部分是否一致即可。

再说下细节，当链表是奇数时，如12321，返回的中点是3，逆序之后是123，而从头遍历的话，是123。当链表是偶数的时候，如1221，返回的中点是2（右边的2），逆序之后是12，而从头遍历的话是122。所以可以看到，逆序的长度小于或等于前半部分的长度，循环判断两部分是否相等的时候，只需要判断逆序的那部分就可以了，因为如果如何逆序的是null了，那么另一部分也是null或者只剩下一个重复的节点。

<h2 id="关于链表的一些练习" >关于链表的一些练习</h2>
这些练习在LeetCode中都属于easy难度的，比较简单，所以重点是要**熟练**掌握，最好做到手写代码。复习或者练习的时候可以写完代码再来对照一下。

- [单链表反转](#单链表反转)
- [链表中环的检测](#链表中环的检测) 
- [两个有序的链表合并](#两个有序的链表合并)
- [删除链表倒数第n个结点](#删除链表倒数第n个结点)
- [求链表的中间结点](#求链表的中间结点)

<h3 id ="单链表反转">单链表反转</h3>

反转比较简单，就是要有一个先前节点prev和当前节点head，要有一个临时节点保存head的下一个节点（head.next），否则反转之后你就找不到下一个节点了。然后让head指向前一个节点prev，prev和head各自指向下一个节点，当然，prev的下一个节点就是head了，而head的下一个节点就是head.next，我们已经放在临时变量里了。

<h3 id ="链表中环的检测">链表中环的检测</h3>

可以参考LeetCode[141.linked-list-cycle](https://leetcode.com/problems/linked-list-cycle/)。

如果有环的存在，遍历就会没有终点，所以如果我们到达了终点（==null），那么我们可以肯定得说这个链表没有环。那么有环怎么判断呢？他一直转圈圈，转到什么时候是个头呢？这里就用到了类似追及问题的解法，找两个人，让一个人跑得快，一个人跑得慢，如果快的人追上了慢的人，那么我们就知道有环的存在。

所以我们设置两个快慢指针，快的每次前进两步，慢的每次前进一步。终止条件是快的人到达了终点（==null），无环。或者是快的人追上了慢的人，有环。

**过程中的错误**：

1. 当时想如果是一个圈，快的人比慢的人每次快一步，那我直接一步一步遍历花费的时间是一样的啊。如果是一个圈，那么这个想法的对的，可以如果是一条直线，是百米冲刺，快的人可以更早到达终点，知道这个链表没有环。

2. 原本写的时候让快的人和慢的人在同一起跑线，两个指针都指向head，结果我的循环判断条件是两个指针相等就跳出循环，这样子整个循环语句就没用的。所以让快的人比慢的人多一步:

   （slow=head；fast=head.next)
   
<h3 id ="两个有序的链表合并">两个有序的链表合并</h3>

我们默认链表都是从小到大的。可以参考LeetCode [21.merge-two-sorted-lists](https://leetcode.com/problems/merge-two-sorted-lists/)

合并链表就是依次找出最小值，然后一个一个连接起来。因为两个链表都是有序的，所以最小值就是两个链表最前面的那一个。

所以一般的思路就是自己创建一个链表，每次从两个链表头中找到较小的那个节点，接到自己的那个链表中。说着很简单，但还是有很多细节要注意。还有一种方法是用递归实现的，原理都差不多，主要是要理解递归的思想，我还领悟到递归的思想，就把代码贴出来，大家自己体会一下。

<h3 id="删除链表倒数第n个结点">删除链表倒数第n个结点</h3>

可以参考LeetCode[19.remove-nth-node-from-end-of-list](https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/) 

有两个指针，第一个指针比第二个指针快n个，也就是两个指针相差n个节点。然后同时一步一步移动两个节点，当第一个指针到尾部时，第二个指针正好到倒数第n个节点。

但有点小问题，因为我们要删除倒数第n个节点，所以我们要得到他前一个节点，也就是倒数n+1个节点，所以两个指针要相距n+1个节点。

<h3 id ="求链表的中间结点">求链表的中间结点</h3>

这个问题就很简单了，其实原本做回文练习的时候就用到了，包括环的检测中也用到了。就是用快慢指针，快的前进两步，慢的前进一步，等到快的指针到结尾时，慢的指针就到了中点。

<h2 id ="排序算法1">排序算法1-O(n^2)</h2>

这里给了时间复杂度为O(n^2)的三种排序方法：冒泡排序，选择排序，插入排序。默认从小到大排序。具体实现看程序：[Sort1](https://github.com/acqierement/algorithmsExercise/blob/master/algorithms/src/list/Sort1.java)

- [冒泡排序](#冒泡排序)
- [选择排序](#选择排序)
- [插入排序](#插入排序)

<h3 id = "冒泡排序" >冒泡排序</h3>

冒泡排序时间复杂度O(n^2),空间复杂度O(1),稳定排序。

冒泡排序就是每次比较相邻的两个数字，如果不是从小到大的顺序，就交换两个数字。比如 3 2 1，比较3 2，然后交换，变成2 3 1，然后比较 3 1，交换变成2 1 3，这样一次“冒泡”，就可以得到最后面的那个数字是最大的，然后再来一次，就可以让倒数第二个就是剩下的数字中最大的。这样几次下来就完成了。

<h3 id = "选择排序" >选择排序</h3>

选择排序，时间复杂度O(n^2),空间复杂度O(1),不稳定排序。由于是不稳定排序，所以基本不用。

选择排序很好理解，第一次，遍历所有的数，找到最小的那个数，将最小的那个数与第一个数交换，这样第一个数就肯定是最小的；第二次，遍历除了第一个的所有数字，找到最小的数，将其与第二个数交换，以此类推。

<h3 id = "插入排序" >插入排序</h3>

插入排序，时间复杂度O(n^2),空间复杂度O(1),稳定排序。插入操作相比较冒泡操作会好一点，虽然二者的时间复杂度一样，但是因为冒泡大量使用交换，而插入就简单的赋值就行了，所以如果很讲究性能的话，插入会比冒泡好一点。

插入排序就像我们拿牌，手上有几张已经排序好的牌，每拿一张牌就要和已经排序好的哪些牌对照一下，看一下要放在哪里。

道理是这样，但是实现起来没有那么简单，那这个插入的操作来说，我们把牌插入很简单，但是在数组中插入要先把位置腾出来才行。具体实现可以看代码。下面我来说说我犯错的地方。

**错误代码：**

```java
// 错误代码
// 插入排序，a 表示数组，n 表示数组大小
public void insertionSort(int[] a, int n) {
  if (n <= 1) return;
  for (int i = 1; i < n; ++i) {
    int value = a[i];
    for (int j = i -1; j >= 0; --j) {
      if (a[j] > value) {
        a[j+1] = a[j];  // 数据移动
      } else {
        a[j+1] = value; // 插入数据
        break;
      }
    }
  }
}

```

这个代码如果传入的是 1 5 3，则可以成功，如果是1 5 3 0，结果是1 1 3 5，0哪去了，其实少了一步，将0赋值给第一个数的这个步骤没有执行。当0和第一个数1判断之后，执行数据移动那一步，但是少了插入数据那一步。

所以正确代码应该是这样的：

```java
for (int i = 1; i < n; ++i) {
    int value = a[i];
    int j = i - 1;
    // 查找插入的位置
    for (; j >= 0; --j) {
      if (a[j] > value) {
        a[j+1] = a[j];  // 数据移动
      } else {
        break;
      }
    }
    a[j+1] = value; // 插入数据
  }


```

可以看到，插入数据的操作，或者说最后的赋值操作是一定需要的，所以可以把赋值语句提到最外层，这样j就不能定义在for循环中。for循环要做的就是腾出空间，移动指针（j）。我觉得这样使用for循环有点奇怪，所以我的代码中就替换成while了。

<h2 id="排序算法2-归并和快排" >排序算法2-归并和快排</h2>

来讲一讲归并排序和快速排序，因为这两个排序算法时间复杂度都是O(nlogn).具体代码在这里：[归并和快排](https://github.com/acqierement/algorithmsExercise/blob/master/algorithms/src/list/Sort2.java)

- [归并排序](#归并排序)
  - 时间复杂度：不管是最好情况还是最坏情况都是 O(nlogn)
  - 空间复杂度：空间复杂度是O(n)。
  - 是否稳定排序：是
- [快速排序](#快速排序)
  - 时间复杂度：最好情况下，选的点正好是在中间O(nlogn),最坏情况下，参考点选的是最大或最小的值，这样就从nlogn退化成O(n^2).
  - 空间复杂度：O(1)
  - 是否稳定排序：否


<h3 id="归并排序" >归并排序</h3>

归并排序其实就是分而治之的思想，就是把一个数组分成两部分，先把左边排好顺序，再把右边排好顺序，然后把两部分按顺序合并，就完成了排序。

既然是分而治之就需要使用递归了。就是原本要对左半部分进行排序，先对左半部分的左半部分进行排序。结果就是一半的一半的一半，直到只有一个。所以时间复杂度会是O(nlogn)，而递归的空间复杂度不能像时间复杂度那么算，虽然每次递归都会产生一个空间，但是调用结束后这个空间就释放了，所以空间复杂度是O(n)。

由于归并排序不是原地排序算法，需要额外的内存空间，所以即使它是稳定排序，使用频率也会比快排小。

遇到的错误：

```java
for(int i = 0; i < temp.length; i++)
			a[i+low] = temp[i];
```

temp里面临时存放了排序好的数组，要把temp里排序好的数据放到原来的数组中。原本我写的是

```java
for(int i = low; i < temp.length; i++)
	a[i] = temp[i];
```

导致我的结果总是不正确，浪费了时间，以后要注意。

<h3 id="快速排序" >快速排序</h3>

快排其实和归并有点类似，归并是将数组从中间分成两部分，分别递归地对两部分进行排序，而快排是选一个参考数，以这个数为参照点，小于它的放右边，大于它的放左边，然后再在右边的部分选一个参照数，将右边部分再分为两部分，以此类推地递归调用。

所以快排主要的就是把数组分成左右两边的函数，我在这里叫做partition函数。这个函数选的参考数是最后一个。接下去的重点就是把如何实现根据参考数字分成两部分。

原本我的想法是有个左右指针指向头尾，然后遍历数组，每个数字不是放在左边，就是放在右边。所以判断一下，然后进行交换。这种方法是对的，但是可以不需要交换。

因为我们有一个参考数字，这个参考数字放到pivot的临时变量中。所以整个数组里面就有了一个空位，我们利用这个空位就可以实现“交换”的操作。

举个例子 5,8,4,9,3,7,2,6，我们先把最后一个数字6作为参考数字，放到pivot变量中，然后有个左右指针指向首尾。然后从左边遍历，5小于6，放在左边没问题，8大于6，应该放在右边，我们就把右边指针所在的数字替换成8，就是原本6的位置，因为6的数字我们原本已经存到pivot变量中了，不用担心数据丢失。然后前面的8所在的位置就没用了，因为8已经换到后面了。然后遍历右边，现在数组是 5,8,4,9,3,7,2,8，8肯定没问题，然后是2，应该放在左边，把左边的8的位置赋值为2，以此类推。

我们发现这样数组中总会有一个空位，这样子我们就能实现“交换”的操作，虽然和一般的交换操作不太一样。

[#归并排序]: 