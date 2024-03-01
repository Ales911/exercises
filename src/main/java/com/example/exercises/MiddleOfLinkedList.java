package com.example.exercises;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleOfLinkedList {

    static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            System.out.println("---IN--- slow: " + slow.val + ", fast: " + fast.val);
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("--OUT--- slow: " + slow.val + ", fast: " + fast.val);
        }

        return slow;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode middle = findMiddle(head);
        if (middle != null) {
            System.out.println("Middle value: " + middle.val);
        } else {
            System.out.println("List is empty.");
        }

    }

}
