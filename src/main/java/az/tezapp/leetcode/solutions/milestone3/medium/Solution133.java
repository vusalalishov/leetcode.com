package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.HashMap;
import java.util.Map;

import az.tezapp.leetcode.solutions.UndirectedGraphNode;

public class Solution133 {

    // ACCEPTED - 100% - optimized
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return cloneGraph(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
                                           Map<Integer, UndirectedGraphNode> labelToNodeMap) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        labelToNodeMap.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!labelToNodeMap.containsKey(neighbor.label)) {
                newNode.neighbors.add(cloneGraph(neighbor, labelToNodeMap));
            } else {
                newNode.neighbors.add(labelToNodeMap.get(neighbor.label));
            }
        }
        return newNode;
    }

}
