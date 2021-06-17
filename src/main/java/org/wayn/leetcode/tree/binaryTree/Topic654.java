package org.wayn.leetcode.tree.binaryTree;

import org.wayn.leetcode.tree.TreeNode;

import java.util.Arrays;

public class Topic654 {


    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length-1);
        }
        /**
         * 利用第二个函数去做base case
         * @param nums
         * @param low
         * @param hi
         * @return
         */
        private TreeNode build(int[] nums, int low, int hi) {
            // base case
            if (hi < low){
                return null;
            }
            int max = Integer.MIN_VALUE;;
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max){
                    index = i;
                    max = nums[i];
                }
            }

            TreeNode root = new TreeNode(max);
            root.left = build(nums, 0, index-1);
            root.right = build(nums, index+1, hi);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nums = Arrays.copyOfRange(nums, 0, 0);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3};
        nums = Arrays.copyOfRange(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
    }

}
