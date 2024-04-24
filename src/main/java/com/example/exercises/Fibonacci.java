package com.example.exercises;

public class Fibonacci {

    public static int nthFibonacciTermBinetsFormula(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5) / 2;
        int nthTerm = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / squareRootOf5);
        return nthTerm;
    }

    public static int nthFibonacciTermR(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return nthFibonacciTerm(n - 1) + nthFibonacciTerm(n - 2);
    }

    public static int nthFibonacciTerm(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int n0 = 0, n1 = 1;
        int tempNthTerm;
        for (int i = 2; i <= n; i++) {
            tempNthTerm = n0 + n1;
            n0 = n1;
            n1 = tempNthTerm;
        }
        return n1;
    }

    public static int steps(int n) {
        if (n <= 2) {
            return n;
        }

        int prevStep = 1, currStep = 2;
        for (int i = 3; i <= n; i++) {
            int nextStep = currStep + prevStep;
            prevStep = currStep;
            currStep = nextStep;
        }
        return currStep;
    }

    public static void main(String[] args) {
        System.out.println("nthFibonacciTerm 0: " + nthFibonacciTerm(0));
        System.out.println("nthFibonacciTerm 1: " + nthFibonacciTerm(1));
        System.out.println("nthFibonacciTerm 2: " + nthFibonacciTerm(2));
        System.out.println("nthFibonacciTerm 3: " + nthFibonacciTerm(3));
        System.out.println("nthFibonacciTerm 4: " + nthFibonacciTerm(4));
        System.out.println("nthFibonacciTerm 5: " + nthFibonacciTerm(5));
        System.out.println("nthFibonacciTermR 10: " + nthFibonacciTermR(10));
        System.out.println("nthFibonacciTermBinetsFormula 10: " + nthFibonacciTermBinetsFormula(10));
        System.out.println("steps 0: " + steps(0));
        System.out.println("steps 1: " + steps(1));
        System.out.println("steps 2: " + steps(2));
        System.out.println("steps 3: " + steps(3));
        System.out.println("steps 4: " + steps(4));
        System.out.println("steps 5: " + steps(5));
    }

}
