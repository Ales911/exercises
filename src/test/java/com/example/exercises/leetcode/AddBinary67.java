package com.example.exercises.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinary67 {

    class R {

        char a;
        char b;
        int carry;
    };

    int add(R r) {
        int result = 0;
        if (r.a != r.b) {
            if (r.carry == 0) {
                result = 1;
            } else {
                result = 0;
                r.carry = 1;
            }
            return result;
        }

        if (r.a == '1') {
            if (r.carry == 0) {
                result = 0;
                r.carry = 1;
            } else {
                result = 1;
                r.carry = 1;
            }
            return result;
        }

        if (r.a == '0') {
            if (r.carry == 0) {
                result = 0;
            } else {
                result = 1;
                r.carry = 0;
            }
        }

        return result;
    }

    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        int indexA = a.length()-1;
        int indexB = b.length()-1;
        R params = new R();
        params.carry = 0;

        while (indexA >= 0 || indexB >= 0) {
            params.a = (indexA >= 0) ? a.charAt(indexA) : '0';
            params.b = (indexB >= 0) ? b.charAt(indexB) : '0';
            result.insert(0, add(params));
            indexA--;
            indexB--;
        }

        if (params.carry > 0) {
            result.insert(0, 1);
        }
        return result.toString();
    }
    
    public String addBinary2(String a, String b) {
        return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
    }
    

    @Test
    public void test1() {
        Assertions.assertEquals("100", addBinary2("11", "1"));
    }
    
    @Test
    public void test2() {
        Assertions.assertEquals("10101", addBinary("1010", "1011"));
    }
    
    @Test
    public void test3() {
        System.out.println("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101");
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Long.parseLong("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 2));
    }
    
}
