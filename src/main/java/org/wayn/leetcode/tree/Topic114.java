package org.wayn.leetcode.tree;

import org.wayn.leetcode.Node;

public class Topic114 {


    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {return;}
            flatten(root.left);
            flatten(root.right);


            TreeNode left = root.left;
            TreeNode right = root.right;


            root.left = null;
            root.right = left;
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }

}
