package com.example.exercises;

public class CalculateExpression {

    int calculate(String expression) {
        System.out.println("expression: " + expression);
        int result = 0;
        int currentVal = 0;
        int currentBlockVal = 1;
        int i = 1;
        for (char c : expression.toCharArray()) {
            System.out.println("i:" +i + ": " + "c: " + c);
            if (c == '+' || c == '*') {
                currentBlockVal *= currentVal;
                if (c == '+') {
                    result += currentBlockVal;
                    currentBlockVal = 1;
                }
                System.out.println("ei:" +i + ": " + "currentVal: " + currentVal + ", currentBlockVal: " + currentBlockVal + ", result: " + result);
                currentVal = 0;
            } else {
                var digit = c - '0';
                currentVal = currentVal * 10 + digit;
            }
            i++;
        }
        currentBlockVal *= currentVal;
        result += currentBlockVal;
        return result;
    }

}
