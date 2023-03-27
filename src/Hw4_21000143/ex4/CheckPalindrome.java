package Hw4_21000143.ex4;

import Hw4_21000143.ex1.ArrayStack;
import Hw4_21000143.ex1.StackInterface;
import Hw4_21000143.ex2.ArrayQueue;
import Hw4_21000143.ex2.QueueInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String s= br.readLine();
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        StackInterface<Character> stack = new ArrayStack<Character>(s.length());
        QueueInterface<Character> queue = new ArrayQueue<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.enqueue(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }
        return true;
    }

}
