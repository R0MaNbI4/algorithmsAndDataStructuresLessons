public class MyLinkedStack<E> {
    MyOneLinkedList<E> linkedList = new MyOneLinkedList<>();

    void push(E item) {
        linkedList.insertFirst(item);
    }

    E pop() {
        return linkedList.removeFirst();
    }

    E pick() {
        return linkedList.getFirst();
    }

    boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
