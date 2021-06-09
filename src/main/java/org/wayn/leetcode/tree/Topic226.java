package org.wayn.leetcode.tree;

public class Topic226 {


    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (null == root){
                return root;
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

}
