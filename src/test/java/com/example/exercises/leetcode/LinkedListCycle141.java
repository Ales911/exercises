package com.example.exercises.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListCycle141 {
    
/**
 * Definition for singly-linked list.
 */
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
    boolean hasCycle(ListNode slow, ListNode fast) {
        if (fast.next == null || fast.next.next == null) {
            return false;
        }
        if (slow == fast) {
            return true;
        }
        return hasCycle(slow.next, fast.next.next);
    }
  
  
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        return hasCycle(head.next, head.next.next);
    }
    
    @Test
    public void lowestCommonAncestorTest1() {
        ListNode r = new ListNode(3);
        r.next = new ListNode(2);
        r.next.next = new ListNode(0);
        r.next.next.next = new ListNode(-4);
        r.next.next.next.next = r.next;
                
        Assertions.assertTrue(hasCycle(r));
    }
    
}
