package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution113 {

    // ACCEPTED - 30%
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        pathSum(root, sum, new ArrayList<>(), paths);
        return paths;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
        sum -= root.val;
        current.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            paths.add(current);
        }
        if (root.left != null) {
            pathSum(root.left, sum, new ArrayList<>(current), paths);
        }
        if (root.right != null) {
            pathSum(root.right, sum, new ArrayList<>(current), paths);
        }
    }

}
