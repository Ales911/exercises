package com.example.exercises.leetcode;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class ImplementQueueusingStacks232 {

    class MyQueue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            if (!s2.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            s1.push(x);
        }

        public int pop() {
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such: MyQueue obj
     * = new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
     * obj.peek(); boolean param_4 = obj.empty();
     */
    @Test
    public void testMyQueue18() {

        //["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
        //[[],[1],[2],[3],[4],[],[5],[],[],[],[]]
        //Use Testcase
        //Output
        //[null,null,null,null,null,1,null,5,2,3,4]
        //Expected
        //[null,null,null,null,null,1,null,2,3,4,5]
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        q.push(5);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
