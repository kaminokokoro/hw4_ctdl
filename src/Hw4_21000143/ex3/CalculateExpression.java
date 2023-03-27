package Hw4_21000143.ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class CalculateExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String s = br.readLine();

        if (isValid(s)) {
            System.out.println(calculateExpression(s));
        } else {
            System.out.println("Invalid expression");
        }

    }

    public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static double calculateExpression(String s) {
        //System.out.println(s);
        Stack<Character> stack = new Stack<>();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                double number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                list.add(number);

            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '('&& list.size() > 1) {
                    list.add(calculate(stack.pop(), list.get(list.size() - 2), list.get(list.size() - 1)));
                    list.remove(list.size() - 2);
                    list.remove(list.size() - 2);
                }
                stack.pop();
            } else if (c == ' ') {
                continue;
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek()) && list.size() > 1) {
                    list.add(calculate(stack.pop(), list.get(list.size() - 2), list.get(list.size() - 1)));
                    list.remove(list.size() - 2);
                    list.remove(list.size() - 2);
                }
                stack.push(c);
            }

            }
            while (!stack.isEmpty() && list.size() > 1 && list.size() > 1) {
                list.add(calculate(stack.pop(), list.get(list.size() - 2), list.get(list.size() - 1)));
                list.remove(list.size() - 2);
                list.remove(list.size() - 2);
        }
        return list.get(0);
    }

    public static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
            case '–':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }


    public static double calculate(char operator, double a, double b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
            case '–':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

}


