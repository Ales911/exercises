package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class BinaryTreeLevelOrderTraversal102 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class TreeNodeEx extends TreeNode {

        int level;

        TreeNodeEx(int val, int level, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(List.of(root.val));
        if (root.left == null && root.right == null) {
            return result;
        }
        Queue<TreeNodeEx> queue = new LinkedList<>();

        queue.add(new TreeNodeEx(root.val, 0, root.left, root.right));

        do {
            TreeNodeEx node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null || right != null) {
                int level = node.level + 1;
                if (level == result.size()) {
                    result.add(new ArrayList<>());
                }
                if (left != null) {
                    queue.add(new TreeNodeEx(left.val, level, left.left, left.right));
                    result.get(level).add(left.val);
                }
                if (right != null) {
                    queue.add(new TreeNodeEx(right.val, level, right.left, right.right));
                    result.get(level).add(right.val);
                }
            }
        } while (!queue.isEmpty());

        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            //add all nodes in queue to list list
            for (int i = 0; i < level; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                list.add(current.val);
            }
            result.add(list);
        }
        return result;
    }

    @Test
    void test() {
        TreeNode given = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> result = levelOrder(given);
        System.out.println(result);
    }

    @Test
    void test5() {
        TreeNode given = new TreeNode(1, new TreeNode(2), null);

        List<List<Integer>> result = levelOrder(given);
        System.out.println(result);
    }

    @Test
    void test16() {
        TreeNode given = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, null, new TreeNode(5)));

        List<List<Integer>> result = levelOrder2(given);
        System.out.println(result);
    }

}
