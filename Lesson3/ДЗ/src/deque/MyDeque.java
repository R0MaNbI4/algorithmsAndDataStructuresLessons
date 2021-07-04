package deque;

import java.util.NoSuchElementException;

public class MyDeque<T> implements MyDequeInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] list;
    private int capacity;
    private int begin;
    private int end;

    public MyDeque(int capacity) {
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void insertLeft(T item) {
        if (isFull()) {
            throw new DequeOverflowException("Deque is full");
        }
        list[prevIndex(begin)] = item;
        begin = prevIndex(begin);
    }

    @Override
    public void insertRight(T item) {
        if (isFull()) {
            throw new DequeOverflowException("Deque is full");
        }
        list[end] = item;
        end = nextIndex(end);
    }

    @Override
    public T removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T temp = peekLeft();
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    @Override
    public T removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T temp = peekRight();
        list[prevIndex(end)] = null;
        end = prevIndex(end);
        return temp;
    }

    @Override
    public T peekLeft() {
        return list[begin];
    }

    @Override
    public T peekRight() {
        return list[prevIndex(end)];
    }

    private int nextIndex(int index) {
        return (index + 1) % capacity;
    }

    private int prevIndex(int index) {
        return (capacity + index - 1) % capacity;
    }

    private boolean isEmpty() {
        return list[begin] == null;
    }

    private boolean isFull() {
        return !isEmpty() && begin == end;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = begin;
        if (isFull()) {
            sb.append(list[i]).append(", ");
            i++;
        }
        while (i != end) {
            sb.append(list[i]);
            i = nextIndex(i);
            sb.append(i != end ? ", " : "");
        }
        sb.append("]");
        return sb.toString();
        //Arrays.toString(list) + " begin: " + begin + " end: " + end;
    }
}
