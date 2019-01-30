package az.tezapp.leetcode.solutions.milestone3;

import java.util.ArrayList;
import java.util.List;

import az.tezapp.leetcode.solutions.TreeNode;

public class Solution103 {

    // ACCEPTED - 100%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        zigzagLevelOrder(root, levels, 0);
        return levels;
    }

    public void zigzagLevelOrder(TreeNode root, List<List<Integer>> levels, int level) {
        if (root == null) {
            return;
        }
        if (levels.size() <= level) {
            levels.add(new ArrayList<>());
        }
        if (level % 2 != 0) {
            levels.get(level).add(root.val);
        } else {
            levels.get(level).add(0, root.val);
        }
        zigzagLevelOrder(root.left, levels, level + 1);
        zigzagLevelOrder(root.right, levels, level + 1);
    }

}
