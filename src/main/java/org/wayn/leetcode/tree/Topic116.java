package org.wayn.leetcode.tree;

import org.wayn.leetcode.Node;

public class Topic116 {


    class Solution {
        public Node connect(Node root) {
            if (null == root) {return root;}
            connectWithParent(root.left, root.right);
            return root;
        }

        // 传入同一父节点的两个子节点 链接左孩子的右节点和右孩子的左节点
        private void connectWithParent(Node left, Node right) {
            if (left == null || right == null){
                return;
            }
            left.next = right;
            connectWithParent(left.left, left.right);
            connectWithParent(left.right, right.left);
            connectWithParent(right.left, right.right);
        }
    }

}
