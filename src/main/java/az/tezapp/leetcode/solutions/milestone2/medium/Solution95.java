package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution95 {

    // ACCEPTED - 94%
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        return generateNodes(1, n);
    }

    private List<TreeNode> generateNodes(int from, int to) {
        if (from > to || from < 1) {
            return Collections.emptyList();
        }
        if (from == to) {
            return Collections.singletonList(new TreeNode(from));
        }
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            List<TreeNode> leftNodes = generateNodes(from, i - 1);
            List<TreeNode> rightNodes = generateNodes(i + 1, to);
            if (leftNodes.size() > 0) {
                if (rightNodes.size() > 0) {
                    for (TreeNode leftNode: leftNodes) {
                        for (TreeNode rightNode: rightNodes) {
                            TreeNode node = new TreeNode(i);
                            node.left = leftNode;
                            node.right = rightNode;
                            nodes.add(node);
                        }
                    }
                } else {
                    for (TreeNode leftNode: leftNodes) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftNode;
                        nodes.add(node);
                    }
                }
            } else if (rightNodes.size() > 0) {
                for (TreeNode rightNode: rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.right = rightNode;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }

}
