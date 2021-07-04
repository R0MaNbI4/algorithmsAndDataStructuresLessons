package stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack<T> implements MyStackInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    T[] list;
    int capacity;
    int size;

    public MyStack(int capacity) {
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            increaseCapacity();
        }
        list[size] = item;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T temp = peek();
        list[size - 1] = null;
        size--;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list[size - 1];
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    private void increaseCapacity() {
        capacity = size + (size/2 + 1);
        T[] tempList = (T[]) new Object[capacity];
        System.arraycopy(list, 0, tempList, 0, size);
        list = tempList;
    }
}
