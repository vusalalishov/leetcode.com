package az.tezapp.leetcode.solutions.milestone3.medium;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution105 {

    // ACCEPTED - 26% [todo: optimize]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        // find the index of val in inorder
        int valIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                valIndex = i;
                break;
            }
        }

        if (valIndex == -1) {
            return null;
        }

        if (valIndex != 0) {
            int[] leftPreorder = new int[valIndex];
            System.arraycopy(preorder, 1, leftPreorder, 0, valIndex);
            int[] leftInorder = new int[valIndex];
            System.arraycopy(inorder, 0, leftInorder, 0, valIndex);
            root.left = buildTree(leftPreorder, leftInorder);
        }

        if (valIndex + 1 < preorder.length) {
            int rightCount = preorder.length - valIndex - 1;
            int[] rightPreorder = new int[rightCount];
            System.arraycopy(preorder, valIndex + 1, rightPreorder, 0, rightCount);

            int[] rightInorder = new int[rightCount];
            System.arraycopy(inorder, valIndex + 1, rightInorder, 0, rightCount);
            root.right = buildTree(rightPreorder, rightInorder);
        }

        return root;
    }

}
