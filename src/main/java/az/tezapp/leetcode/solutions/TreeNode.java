package az.tezapp.leetcode.solutions;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode of(Integer[] input) {
        return of(input, 0);
    }

    public static TreeNode of(Integer[] input, int index) {
        if (index >= input.length || input[index] == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(input[index]);
        treeNode.left = of(input, index * 2 + 1);
        treeNode.right = of(input, index * 2 + 2);
        return treeNode;
    }

}
