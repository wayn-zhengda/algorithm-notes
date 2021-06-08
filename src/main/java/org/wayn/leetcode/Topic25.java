package org.wayn.leetcode;

public class Topic25 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    // 反转链表 迭代解法
//    public ListNode reverse(ListNode node){
//        ListNode pre = null;
//        ListNode cur = node;
//        ListNode next = node;
//        while (cur != null){
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }



    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode cur = head;
            ListNode last = head;
            for (int i = 0; i < k; i++) {
                if (last == null){
                    return cur;
                }
                last = last.next;
            }
            ListNode newHead = reverse(cur, last);
            cur.next = reverseKGroup(last, k);
            return newHead;
        }
        public ListNode reverse(ListNode node, ListNode last){
            ListNode pre = null;
            ListNode cur = node;
            ListNode next = node;
            while (cur != last) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }


}
