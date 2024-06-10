package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class CloneGraph133 {

    class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node result = new Node(node.val);
        Node[] visited = new Node[101];

        visited[result.val] = result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node origin = null;
        Node clone = null;
        List<Node> neighbors = null;
        List<Node> neighborsClone = null;
        Node childClone = null;

        do {
            origin = queue.poll();
            clone = visited[origin.val];

            neighbors = origin.neighbors;
            neighborsClone = clone.neighbors;

            if (neighbors.size() > neighborsClone.size()) {
                for (Node child : neighbors) {
                    if (visited[child.val] == null) {
                        childClone = new Node(child.val);
                        visited[childClone.val] = childClone;
                        queue.add(child);
                    } else {
                        childClone = visited[child.val];
                    }
                    neighborsClone.add(childClone);
                }
            }
        } while (!queue.isEmpty());

        return result;
    }

    List<Integer> getneighbors(Node node) {
        List result = new ArrayList<>();
        for (Node tmp : node.neighbors) {
            result.add(tmp.val);
        }
        return result;
    }

    @Test
    void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);

        System.out.println(node1.val + ": " + getneighbors(node1));
        System.out.println(node2.val + ": " + getneighbors(node2));
        System.out.println(node3.val + ": " + getneighbors(node3));
        System.out.println(node4.val + ": " + getneighbors(node4));

        node1 = cloneGraph(node1);
        System.out.println(node1.val + ": " + getneighbors(node1));
        node2 = node1.neighbors.get(0);
        node4 = node1.neighbors.get(1);

        System.out.println(node2.val + ": " + getneighbors(node2));
        System.out.println(node4.val + ": " + getneighbors(node4));

        node3 = node2.neighbors.get(1);

        System.out.println(node3.val + ": " + getneighbors(node3));

    }

}
