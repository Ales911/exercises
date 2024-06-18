package com.example.exercises.leetcode;

import java.util.Stack;

public class LowestCommonAncestorofaBinaryTree236 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // If both left and right subtrees return a non-NULL value, 
        // it means that p and q are found in different subtrees, 
        // and the current node is the lowest common ancestor.        
        if (l != null && r != null) {
            return root;
        }


        // If only one subtree returns a non-NULL value,
        // it means that both p and q are in the same subtree,
        // and the function continues to propagate the common ancestor.
        if (l != null) {
            return l;
        } else {
            return r;
        }
    }

}
