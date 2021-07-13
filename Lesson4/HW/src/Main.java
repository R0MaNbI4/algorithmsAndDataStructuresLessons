import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //testStack(5);
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.insertFirst(i);
        }

        for (Integer i : linkedList) {
            System.out.print(i);
        }

        System.out.println();

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }

    private static void testStack(int stackSize) {
        MyLinkedStack<Integer> myStack = new MyLinkedStack<>();
        int temp;
        for (int i = 0; i < stackSize; i++) {
            myStack.push(i);
            System.out.println(myStack);
        }
        for (int i = 0; i < stackSize; i++) {
            temp = myStack.pop();
            System.out.println(myStack + " return: " + temp);
        }
    }
}
