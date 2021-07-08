package stack;

public interface MyStackInterface<T> {
    void push(T item);
    T pop();
    T peek();
}
