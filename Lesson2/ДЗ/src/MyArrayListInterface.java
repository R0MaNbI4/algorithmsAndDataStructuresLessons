public interface MyArrayListInterface<T extends Comparable<T>> {
    void add(T item);
    void add(int index, T item);
    void remove (int index);
    boolean remove (T item);
    T get(int index);
    void set(int index, T item);
    boolean contains(T item);
    int indexOf(T item);
    int size();
}
