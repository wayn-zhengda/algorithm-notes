package org.wayn.leetcode;

public class Topic234 {


    class Solution {
        ListNode left;
        public boolean isPalindrome(ListNode head) {
            left = head;
            return doIsPalindrome(head);
        }

        /**
         * 通过链表后序遍历的形式，首先right节点会通过递归的调用指到链表最后一个节点，此时开始比较left和right的值，
         * @param right
         * @return
         */
        private boolean doIsPalindrome(ListNode right) {
            if (right == null) return true;
            boolean b = doIsPalindrome(right.next);
            boolean res = b && (right.val == left.val);
            // left不断指向下一个节点
            left = left.next;
            return res;
        }
    }

}
