package com.example.exercises.leetcode;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinStack155 {

    class MinStack {

        Stack<Integer> stack = new Stack<>();
        Integer min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            if (val < min) {
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            Integer val = stack.pop();
            if (stack.empty()) {
                min = Integer.MAX_VALUE;
            } else {
                if (val.equals(min)) {
                    min = stack.get(0);
                    for (int i = 1; i < stack.size(); i++) {
                        Integer candidate = stack.get(i);
                        if (candidate < min) {
                            min = candidate;
                        }
                    }
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    @Test
    void test1() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        Assertions.assertEquals(-3, stack.getMin());
        stack.pop();
        Assertions.assertEquals(0, stack.top());
        Assertions.assertEquals(-2, stack.getMin());
    }

    @Test
    void test2() {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        Assertions.assertEquals(2147483647, stack.top());
        stack.pop();
        Assertions.assertEquals(2147483646, stack.getMin());
        stack.pop();
        Assertions.assertEquals(2147483646, stack.getMin());
        stack.pop();
        stack.push(2147483647);
        Assertions.assertEquals(2147483647, stack.top());
        Assertions.assertEquals(2147483647, stack.getMin());
        stack.push(-2147483648);
        Assertions.assertEquals(-2147483648, stack.top());
        Assertions.assertEquals(-2147483648, stack.getMin());
        stack.pop();
        Assertions.assertEquals(2147483647, stack.getMin());
    }

}
