package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateBinarySearchTree98 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {

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

    TreeNode prev = null;

    boolean isValidBSTEx(TreeNode node, List<Integer> list, int index) {
        boolean result = true;
        if (node.right != null) {
            if (node.right.val <= node.val) {
                return false;
            }
            int indexNew = index + 1;
            if (indexNew == list.size()) {
                list.add(node.right.val);
            } else {
                list.add(indexNew, node.right.val);
            }
            if (!isValidBSTEx(node.right, list, indexNew)) {
                return false;
            }
        }
        if (node.left != null) {
            if (node.left.val >= node.val) {
                return false;
            }
            list.add(index, node.left.val);
            result = isValidBSTEx(node.left, list, index);
        }

        return result;
    }
    
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (!isValidBSTEx(root, list, 0)) {
            return false;
        }

        boolean result = true;
        int pred = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer cur = list.get(i);
            if (cur <= pred) {
                result = false;
                break;
            } else {
                pred = cur;
            }
        }
        return result;
    }

    @Test
    void test() {
        Assertions.assertTrue(isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        // void test60()
        Assertions.assertTrue(isValidBST(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)))));
        // void test66()
        Assertions.assertFalse(isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(2))));
        // test77() 
        Assertions.assertFalse(isValidBST(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
        // test81() 
        Assertions.assertFalse(isValidBST(new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null), new TreeNode(47, null, new TreeNode(56)))));
    }

}
