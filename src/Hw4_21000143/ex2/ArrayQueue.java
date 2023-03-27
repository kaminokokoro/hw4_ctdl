package Hw4_21000143.ex2;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E>{
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }
    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) {
        if (count == n) {
            System.out.println("Queue is full");
        } else {
            queue[(top + count) % n] = element;
            count++;
        }
    }
    @Override
    public E dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return null;
        } else {
            E element = queue[top];
            top = (top + 1) % n;
            count--;
            return element;
        }
    }
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new ArrayQueueIterator();
    }
    class ArrayQueueIterator<E> implements Iterator<E> {
        private int current = top;
        private int num = 0;
        @Override
        public boolean hasNext() {
        // TODO Auto-generated method stub
            return num < count;
        }
        @Override
        public E next() {
        // TODO Auto-generated method stub
            E data = (E) queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
