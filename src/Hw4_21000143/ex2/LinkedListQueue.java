package Hw4_21000143.ex2;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;
    }
    Node queue = null;
    @Override
    public void enqueue(E element) {
        Node node = new Node();
        node.element = element;
        node.next = queue;
        queue = node;
    }
    @Override
    public E dequeue() {
        if (queue == null) {
            System.out.println("Queue is empty");
            return null;
        } else {
            E element = queue.element;
            queue = queue.next;
            return element;
        }
    }
    @Override
    public boolean isEmpty() {
        return queue == null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new QueueIterator();
    }
    class QueueIterator implements Iterator<E> {
        private Node current = queue;
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
