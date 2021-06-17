package org.wayn.leetcode.tree.binaryTree;

import org.wayn.leetcode.tree.TreeNode;


public class Topic105 {


    static class  Solution {
        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

            if (preStart > preEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
            int index = 0;
            TreeNode root = new TreeNode(rootVal);
            for (int i = 0; i < inorder.length; i++) {
                if (rootVal == inorder[i]) {
                    index = i;
                }
            }
            int leftSizde = index - inStart;
            root.left = build(preorder, preStart + 1, preStart + leftSizde, inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSizde + 1, preEnd, inorder, index + 1, inEnd);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = Solution.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}

