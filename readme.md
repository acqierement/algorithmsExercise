algorithmsDemo

1. 单链表判断是否是回文。回文就是从左到右和从右到左都是一样的，比如123321,45654.

   第一种方法：[isPalindrome](https://github.com/acqierement/algorithmsExercise/blob/master/algorithms/src/list/Palindrome_linked_list_234.java)。就是把链表逆序排列，再和原来的链表相比较是不是完全一样。由于逆序会破坏原来链表的顺序，所以先copy一份。

   第二种方法：。就是先找到链表的中点，然后判断中点的左右部分是否关于中点对称。如何快速找到中点呢？就用快慢指针的方法，慢指针每次前进一步，快指针每次前进两步，这样当快指针走到末尾的时候，慢指针就到了中点
