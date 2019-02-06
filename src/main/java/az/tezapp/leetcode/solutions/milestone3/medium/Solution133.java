package az.tezapp.leetcode.solutions.milestone3.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import az.tezapp.leetcode.solutions.UndirectedGraphNode;

public class Solution133 {

    // ACCEPTED - 78%
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return cloneGraph(node, new HashSet<>(), new HashMap<>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
                                           Set<Integer> visited,
                                           Map<Integer, UndirectedGraphNode> labelToNodeMap) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.add(node.label);
        labelToNodeMap.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor.label)) {
                newNode.neighbors.add(cloneGraph(neighbor, visited, labelToNodeMap));
            } else {
                newNode.neighbors.add(labelToNodeMap.get(neighbor.label));
            }
        }
        return newNode;
    }

}
