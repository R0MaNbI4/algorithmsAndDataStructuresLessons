package deque;

public interface MyDequeInterface<T> {
    void insertLeft(T item);
    void insertRight(T item);
    T removeLeft();
    T removeRight();
    T peekLeft();
    T peekRight();
}
