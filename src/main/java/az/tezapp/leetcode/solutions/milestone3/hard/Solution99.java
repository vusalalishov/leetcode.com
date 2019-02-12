package az.tezapp.leetcode.solutions.milestone3.hard;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution99 {

    // ACCEPTED - 92%
    public void recoverTree(TreeNode root) {
        TreeNode[] brokenNodes = new TreeNode[2];
        inOrderTraverseAndFindBrokenNodes(root, brokenNodes, null);
        swapValues(brokenNodes[0], brokenNodes[1]);
    }

    private void swapValues(TreeNode node1, TreeNode node2) {
        int tmpVal = node1.val;
        node1.val = node2.val;
        node2.val = tmpVal;
    }

    private TreeNode inOrderTraverseAndFindBrokenNodes(TreeNode node,
                                                       TreeNode[] nodes,
                                                       TreeNode lastNode) {
        if (node == null) {
            return lastNode;
        }
        lastNode = inOrderTraverseAndFindBrokenNodes(node.left, nodes, lastNode);
        if (lastNode != null) {
            if (lastNode.val > node.val) {
                if (nodes[0] == null) {
                    nodes[0] = lastNode;
                    nodes[1] = node;
                } else {
                    nodes[1] = node;
                    return null;
                }
            }
        }
        lastNode = node;
        return inOrderTraverseAndFindBrokenNodes(node.right, nodes, lastNode);
    }

}
