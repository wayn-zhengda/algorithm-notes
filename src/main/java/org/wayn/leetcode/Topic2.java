package org.wayn.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Topic2 {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode();
        listNodeBuilder(listNode11, Arrays.asList(9,9,9,9,9,9,9));
        ListNode listNode21 = new ListNode();
        listNodeBuilder(listNode21, Arrays.asList(9,9,9,9));

        ListNode listNode = Solution.addTwoNumbers(listNode11, listNode21);
        System.out.println(listNode);
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();

            if (null != l1 || null != l2){
                int val1 = null==l1?0:l1.val;
                int val2 = null==l2?0:l2.val;
                result.val = val1+val2;
                // 需要进位
                if (val1+val2-10>=0){
                    result.val = val1+val2-10;
                    if (null == l1.next){
                        l1.next = new ListNode(1);
                    }else {
                        l1.next.val = l1.next.val+1;
                    }
                }
                if (null != l1.next || null != l2.next){
                    l1.next = null==l1.next?new ListNode(0):l1.next;
                    l2.next = null==l2.next?new ListNode(0):l2.next;
                    ListNode listNode = addTwoNumbers(l1.next, l2.next);
                    result.next = listNode;
                }
            }
            return result;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode listNodeBuilder(ListNode listNode, List<Integer> values){
        if (values.size() == 0){
            return null;
        }
        listNode.val = values.get(0);
        listNode.next = listNodeBuilder(new ListNode(), values.subList(1, values.size()));
        return listNode;
    }
}
