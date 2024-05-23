package com.example.exercises.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstBadVersion278 {

    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
    
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        do {
            // System.out.println("start: " + start + ", end: " + end);
            int dif = end - start;

            if (dif < 5) {
                for (int i = start; i <= end; i++) {
                    if (isBadVersion(i)) {
                        return i;
                    }
                }
                return 0;
            }

            int middle = start + (dif / 2);
            // System.out.println("middle: " + middle);
            // System.out.println(isBadVersion(middle));

            if (isBadVersion(middle)) {
                end = middle;
            } else {
                start = middle;
            }

        } while (start < end);

        return 0;

    }
    
    @Test
    public void test11() {
        Assertions.assertEquals(1702766719, firstBadVersion(2126753390));
    }
}
