package com.example.exercises.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LowestCommonAncestorBinarySearchTree235 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (p == null || q == null) {
            return root;
        }
        
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }

    @Test
    public void lowestCommonAncestorTest1() {
        TreeNode r = new TreeNode(6);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(0);
        r.left.right = new TreeNode(4);
        r.left.right.left = new TreeNode(3);
        r.left.right.left = new TreeNode(5);
        r.right = new TreeNode(8);
        r.right.left = new TreeNode(7);
        r.right.right = new TreeNode(9);

        Assertions.assertEquals(6, lowestCommonAncestor(r, r.left, r.right).val);
    }

    @Test
    public void lowestCommonAncestorTest2() {
        TreeNode r = new TreeNode(6);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(0);
        r.left.right = new TreeNode(4);
        r.left.right.left = new TreeNode(3);
        r.left.right.left = new TreeNode(5);
        r.right = new TreeNode(8);
        r.right.left = new TreeNode(7);
        r.right.right = new TreeNode(9);

        Assertions.assertEquals(2, lowestCommonAncestor(r, r.left, r.left.right).val);
    }

    @Test
    public void lowestCommonAncestorTest3() {
        TreeNode r = new TreeNode(2);
        r.left = new TreeNode(1);

        Assertions.assertEquals(2, lowestCommonAncestor(r, r, r.left).val);
    }

    @Test
    public void lowestCommonAncestorTest6() {
        TreeNode r = new TreeNode(2);
        r.left = new TreeNode(1);

        Assertions.assertEquals(2, lowestCommonAncestor(r, r.left, r).val);
    }
    
    @Test
    public void lowestCommonAncestorTest13() {
        TreeNode r = new TreeNode(2);
        r.left = new TreeNode(1);
        r.right = new TreeNode(3);

        Assertions.assertEquals(2, lowestCommonAncestor(r, r.right, r.left).val);
    }
    

}
