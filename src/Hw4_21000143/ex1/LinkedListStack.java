package Hw4_21000143.ex1;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }
    Node stack = null;
    @Override
    public void push(E element) {
        Node node = new Node();
        node.element = element;
        node.next = stack;
        stack = node;
    }
    public E pop() {
        if (stack == null) {
            System.out.println("Stack is empty");
            return null;
        } else {
            E element = stack.element;
            stack = stack.next;
            return element;
        }
    }
    public boolean isEmpty() {
        return stack == null;
    }
    public E top() {
        if (stack == null) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return stack.element;
        }
    }
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }
    class StackIterator implements Iterator<E> {
        private Node current = stack;
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }
        @Override
        public E next() {
            // TODO Auto-generated method stub
            E element = current.element;
            current = current.next;
            return element;
        }
    }
}
