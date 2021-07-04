package queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<T> implements MyQueueInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;

    T[] list;
    int capacity;
    int begin;
    int end;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void insert(T item) {
        if (isFull()) {
            increaseCapacity();
        }
        list[end] = item;
        end = nextIndex(end);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T temp = peek();
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    @Override
    public T peek() {
        return list[begin];
    }

    private int nextIndex(int index) {
        return nextIndex(index, 1);
    }

    private int nextIndex(int index, int shift) {
        return (index + shift) % capacity;
    }

    private void increaseCapacity() {
        int oldCapacity = capacity;
        int newCapacity = oldCapacity + (oldCapacity / 2 + 1);
        capacity = newCapacity;
        T[] tempList = (T[]) new Object[newCapacity];
        System.arraycopy(list, begin, tempList, begin + newCapacity - oldCapacity, oldCapacity - begin);
        System.arraycopy(list, 0, tempList, 0, end);
        begin = nextIndex(begin, newCapacity - oldCapacity);
        list = tempList;
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
