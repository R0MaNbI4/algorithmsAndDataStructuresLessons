package queue;

public interface MyQueueInterface<T> {
    void insert(T item);
    T remove();
    T peek();
}
