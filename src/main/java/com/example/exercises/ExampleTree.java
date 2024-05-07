package com.example.exercises;

import java.util.LinkedList;
import java.util.Stack;

public class ExampleTree {

    static class Tree implements Comparable<Tree>{

        int value;
        Tree left;
        Tree right;

        Tree(int value) {
            this.value = value;
        }

        Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Tree o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4, null, new Tree(6)), new Tree(9)),
                new Tree(35,
                        new Tree(31, new Tree(28), null),
                        new Tree(40, new Tree(38), new Tree(52))));
        System.out.println(summDeep(root));
        System.out.println(summWide(root));
    }

    static int summDeep(Tree root) {
        int result = 0;

        Stack<Tree> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            result = node.value + result;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }
    
    static int summWide(Tree root) {
        int result = 0;

        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            result = node.value + result;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }
    
    

}
