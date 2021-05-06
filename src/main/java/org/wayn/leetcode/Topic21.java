package org.wayn.leetcode;

import java.util.Arrays;
import java.util.List;

public class Topic21 {
    public static void main(String[] args) {
//        ListNode listNode11 = new ListNode();
//        listNodeBuilder(listNode11, Arrays.asList(1,2,4));
//        ListNode listNode21 = new ListNode();
//        listNodeBuilder(listNode21, Arrays.asList(1,3,4));

        ListNode listNode11 = new ListNode();
        listNodeBuilder(listNode11, Arrays.asList(-9,3));
        ListNode listNode21 = new ListNode();
        listNodeBuilder(listNode21, Arrays.asList(5,7));

        ListNode listNode = Solution.mergeTwoLists(listNode11, listNode21);
        System.out.println(listNode);
    }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (null == l1 && null == l2){
               return null;
            }
            if (null == l1 ){
                return l2;
            }
            if (null == l2){
                return l1;
            }
            ListNode c1 =l1;
            ListNode c2 = l2;
            ListNode mergeRoot = new ListNode();
            ListNode curentMergeNode = mergeRoot;
            for (int i = 0;; i++) {
                if (c1.val <= c2.val){
                    curentMergeNode.val = c1.val;
                    if (null != c1.next){
                        c1 = c1.next;
                        curentMergeNode.next = new ListNode();
                        curentMergeNode = curentMergeNode.next;
                    }else {
                        curentMergeNode.next = c2;
                        break;
                    }
                    continue;
                }
                curentMergeNode.val = c2.val;
                if (null != c2.next){
                    c2 = c2.next;
                    curentMergeNode.next = new ListNode();
                    curentMergeNode = curentMergeNode.next;
                }else {
                    curentMergeNode.next = c1;
                    break;
                }
            }
            return mergeRoot;
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

    static void doMerge(ListNode parentL1, ListNode currentL1, ListNode currentL2){
        if (null != currentL1.next && currentL1.val <= currentL2.val){
            if (null == currentL1.next){
                currentL1.next = currentL2;
            }
            doMerge(currentL1, currentL1.next, currentL2);
        }
        currentL2.next = currentL1;
        parentL1.next = currentL2;
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
