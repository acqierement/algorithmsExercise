# algorithmsDemo

用来记录一下学习算法的一些练习。

## 目录

- [单链表判断是否是回文](#单链表判断是否是回文)
- [关于链表的一些练习](#关于链表的一些练习)

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