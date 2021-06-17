package org.wayn.leetcode.tree.binaryTree;

import org.wayn.leetcode.tree.TreeNode;

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
