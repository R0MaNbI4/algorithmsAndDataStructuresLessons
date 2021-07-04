import deque.MyDeque;
import queue.MyQueue;
import stack.MyStack;

public class Main {
    public static void main(String[] args) {
        //testMyStack(5, 10);
        System.out.println(flip("Hello, world!"));
        testMyQueue(5,10);
        testMyDeque(10);
    }

    private static String flip(String s) {
        // O(n^2)
        MyStack<Character> myStack = new MyStack<>();
        for (int i = 0; i < s.length(); i++) {
            myStack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(myStack.pop());
        }
        return sb.toString();
    }

    private static void testMyStack(int stackCapacity, int stackSize) {
        MyStack<Integer> myStack = new MyStack<>(stackCapacity);
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

    private static void testMyQueue(int queueCapacity, int queueSize) {
        MyQueue<Integer> myQueue = new MyQueue<>(queueCapacity);
        int temp;
        for (int i = 0; i < queueSize; i++) {
            myQueue.insert(i);
            System.out.println(myQueue);
        }
        for (int i = 0; i < queueSize; i++) {
            temp = myQueue.remove();
            System.out.println(myQueue + " return: " + temp);
        }
    }

    private static void testMyDeque(int dequeCapacity) {
        MyDeque<Integer> myDeque = new MyDeque<>(dequeCapacity);
        int temp;
        for (int i = 0; i < dequeCapacity; i++) {
            if (i % 2 == 0) {
                myDeque.insertLeft(i);
            } else {
                myDeque.insertRight(i);
            }
            System.out.println(myDeque);
        }
        for (int i = 0; i < dequeCapacity; i++) {
            temp = i % 2 == 0 ? myDeque.removeRight() : myDeque.removeLeft();
            System.out.println(myDeque + " return: " + temp);
        }
    }
}
