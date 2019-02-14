package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution236 {

    // ACCEPTED - 25% [TODO: optimize it]
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> pNodes = new ArrayList<>();
        List<Integer> qNodes = new ArrayList<>();
        findPathToNodes(root, p, q, pNodes, qNodes);

        int len = Math.min(pNodes.size(), qNodes.size());
        int i = 0;
        while (i < len && pNodes.get(i).equals(qNodes.get(i))) {
            i++;
        }
        return new TreeNode(pNodes.get(i - 1));
    }

    private void findPathToNodes(TreeNode root,
                                 TreeNode p,
                                 TreeNode q,
                                 List<Integer> pNodes,
                                 List<Integer> qNodes) {

        if (root == null) {
            return;
        }
        if (pNodes.size() == 0 || !pNodes.get(pNodes.size() - 1).equals(p.val)) {
            pNodes.add(root.val);
        }
        if (qNodes.size() == 0 || !qNodes.get(qNodes.size() - 1).equals(q.val)) {
            qNodes.add(root.val);
        }

        findPathToNodes(root.left, p, q, pNodes, qNodes);
        findPathToNodes(root.right, p, q, pNodes, qNodes);

        if (pNodes.size() != 0 && !pNodes.get(pNodes.size() - 1).equals(p.val)) {
            pNodes.remove(pNodes.size() - 1);
        }

        if (qNodes.size() != 0 && !qNodes.get(qNodes.size() - 1).equals(q.val)) {
            qNodes.remove(qNodes.size() - 1);
        }

    }

}
