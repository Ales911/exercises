package com.example.exercises.leetcode;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class ReverseLinkedList206 {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = null;
        ListNode p3 = null;
        ListNode t = null;

        boolean b = true;
        while (p1.next != null) {
            p2 = p1.next;
            t = p2;
            p2 = p1;
            p1 = t;
            if (b) {
                b = false;
                p2.next = null;
            } else {
                p2.next = p3;
            }
            p3 = p2;
        }
        p1.next = p2;

        return p1;
    }

    @Test
    public void test1() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        node = reverseList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
