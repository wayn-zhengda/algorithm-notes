package org.wayn.leetcode;

import java.util.Arrays;
import java.util.List;

public class Topic92 {
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

    // 反转链表 递归解法
//    public ListNode reverse(ListNode head){
//        if (head.next == null){
//            return head;
//        }
//        ListNode last = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head.next == null){
                return head;
            }
            if (left == 1){
                return reverseLeft(head, right);
            }
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

        // 反转链表前left个
        ListNode successor = null; // 后驱节点
        public ListNode reverseLeft(ListNode head, int left){
            if (left == 1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseLeft(head.next, left - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
