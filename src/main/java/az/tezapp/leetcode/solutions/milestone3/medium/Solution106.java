package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.HashMap;
import java.util.Map;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution106 {

    // ACCEPTED - 96%
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, inorderMap, 0, postorder.length, 0, inorder.length);

    }

    private TreeNode buildTree(int[] inorder,
                               int[] postorder,
                               Map<Integer, Integer> inorderMap,
                               int postFrom,
                               int postTo,
                               int inFrom,
                               int inTo) {
        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        int rootVal = postorder[postTo - 1];
        TreeNode node = new TreeNode(rootVal);
        int valIndex = inorderMap.get(rootVal);

        if (valIndex > inFrom) {
            node.left = buildTree(inorder, postorder, inorderMap, postFrom, postFrom + (valIndex - inFrom), inFrom, valIndex);
        }

        if (valIndex < inTo - 1) {
            node.right = buildTree(inorder, postorder, inorderMap, postFrom + (valIndex - inFrom), postTo - 1, valIndex + 1, inTo);
        }

        return node;
    }

}
