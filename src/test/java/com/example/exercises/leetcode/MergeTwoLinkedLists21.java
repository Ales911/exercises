package com.example.exercises.leetcode;

public class MergeTwoLinkedLists21 {

    class ListNode {

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

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode result = null;
        ListNode p = null;
        while ((p1 != null) || (p2 != null)) {
            if (p == null) {
                p = new ListNode();
                result = p;
            } else {
                p.next = new ListNode();
                p = p.next;
            }
            if ((p1 != null) && (p2 != null)) {
                if (p1.val <= p2.val) {
                    p.val = p1.val;
                    p1 = p1.next;
                } else {
                    p.val = p2.val;
                    p2 = p2.next;
                }
            } else {
                if (p1 == null) {
                    p.val = p2.val;
                    p2 = p2.next;
                } else { // p2 = null
                    p.val = p1.val;
                    p1 = p1.next;
                }
            }
        }

        return result;
    }

    ListNode start() {
        return mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))));
    }

    public static void main(String[] args) {
        ListNode result = new MergeTwoLinkedLists21().start();
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
