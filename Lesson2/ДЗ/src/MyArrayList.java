import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements MyArrayListInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private int size;
    private T[] list;

    MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(String.format("Capacity: %s. Must be > 0", capacity));
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T item) {
        if (isExcessCapacity()) {
            increaseCapacity();
        }
        list[size] = item;
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (!isIndexInBounds(index)) {
            throw new IllegalArgumentException(String.format("Index: %d. Must be between 0 and %d", index, size));
        }
        if (isExcessCapacity()) {
            increaseCapacity();
        }
        System.arraycopy(list, index, list, index + 1, size - index);
//        for (int i = size; i > index; i--) {
//            list[i] = list[i - 1];
//        }
        list[index] = item;
        size++;
    }

    public void add(MyArrayList<T> arrayList) {
        if (capacity < size + arrayList.size) {
            increaseCapacity(size + arrayList.size);
        }
        for (int i = size; i < size + arrayList.size; i++) {
            list[i] = arrayList.get(i - size);
        }
        size += arrayList.size;
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayList is empty");
        }
        if (!isIndexInBounds(index)) {
            throw new IllegalArgumentException(String.format("Index: %d. Must be between 0 and %d", index, size));
        }
        System.arraycopy(list,index + 1, list, index, size - index - 1);
//        for (int i = index; i < size - 1; i++) {
//            list[i] = list[i + 1];
//        }
        size--;
        list[size] = null; // Чтобы не было утечки памяти
    }

    @Override
    public T get(int index) {
        if (!isIndexInBounds(index)) {
            throw new IllegalArgumentException(String.format("Index: %d. Must be between 0 and %d", index, size));
        }
        return list[index];
    }

    @Override
    public void set(int index, T item) {
        if (!isIndexInBounds(index)) {
            throw new IllegalArgumentException(String.format("Index: %d. Must be between 0 and %d", index, size));
        }
        list[index] = item;
    }

    public void set(MyArrayList<T> arrayList) {
        if (capacity < arrayList.size) {
            increaseCapacity(arrayList.size);
        }
        for (int i = 0; i < arrayList.size; i++) {
            list[i] = arrayList.get(i);
        }
        size = arrayList.size;
    }

    @Override
    public boolean remove(T item) {
        int index = index(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean contains(T item) {
        return index(item) != -1;
    }

    // Если метод используется в других методах, то, чтобы ничего не сломалось, делаем его финальным или приватным
    @Override
    public int indexOf(T item) {
        return index(item);
    }

    private int index(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(list, null);
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    private void increaseCapacity() {
        capacity = size + (size/2 + 1);
        T[] tempList = (T[]) new Comparable[capacity];
        System.arraycopy(list, 0, tempList, 0, size);
        list = tempList;
    }

    private void increaseCapacity(int capacity) {
        this.capacity = capacity;
        T[] tempList = (T[]) new Comparable[capacity];
        System.arraycopy(list, 0, tempList, 0, size);
        list = tempList;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isIndexInBounds(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isExcessCapacity() {
        return size + 1 > capacity;
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public void selectionSort() {
        int min = 0;
        for (int i = 0; i < size; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j],list[min])) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    public void insertionSort() {
        T value;
        int idx;
        for (int i = 1; i < size; i++) {
            value = list[i];
            idx = i;
            while (idx > 0 && less(value, list[idx - 1])) {
                list[idx] = list[idx - 1];
                idx--;
            }
            list[idx] = value;
        }
    }

    public void swap(int idx1, int idx2) {
        T temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }
}