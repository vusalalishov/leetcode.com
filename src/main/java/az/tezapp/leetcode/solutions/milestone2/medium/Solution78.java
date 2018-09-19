package az.tezapp.leetcode.solutions.milestone2.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution78 {

    // ACCEPTED
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> out = new ArrayList<>();

        out.add(Collections.emptyList());

        Map<String, Integer> nodeCount = new HashMap<>();
        Map<String, Integer> visitedNodeCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int root = nums[i];
            LinkedList<Integer> backStack = new LinkedList<>();
            LinkedList<Integer> dfsStack = new LinkedList<>();

            visitedNodeCount.putIfAbsent(backStack.toString(), 0);
            nodeCount.putIfAbsent(backStack.toString(), 1);

            dfsStack.push(root);

            while (!dfsStack.isEmpty()) {
                Integer node = dfsStack.pop();

                String parentNodeKey = backStack.toString();

                Integer visitedCount = visitedNodeCount.get(parentNodeKey);
                visitedNodeCount.put(parentNodeKey, visitedCount + 1);

                backStack.push(node);
                String childNodeKey = backStack.toString();
                visitedNodeCount.put(childNodeKey, 0);

                int[] children = getChildrenFor(node, nums);
                nodeCount.put(childNodeKey, children.length);

                // add children to queue
                for (Integer item: children) {
                    dfsStack.push(item);
                }

                List<Integer> data = new ArrayList<>(backStack);
                out.add(data);

                while (!backStack.isEmpty() && visitedNodeCount.get(childNodeKey) >= nodeCount.get(childNodeKey)) {
                    backStack.pop();
                    childNodeKey = backStack.toString();
                }
            }
        }

        return out;

    }

    private int[] getChildrenFor(int item, int[] nums) {
        int i = 0;
        while (nums[i] != item) {
            i++;
        }
        int len = nums.length - i - 1;
        if (len == 0) {
            return new int[0];
        }
        int[] children = new int[len];
        System.arraycopy(nums, i + 1, children, 0, len);
        return children;
    }

    public static void main(String[] args) {
        Solution78 sol = new Solution78();
        System.out.println(sol.subsets(new int[] {0, 3, 2}));
    }

}
