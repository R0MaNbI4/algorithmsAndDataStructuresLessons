package deque;

public class DequeOverflowException extends RuntimeException {
    public DequeOverflowException(String message) {
        super(message);
    }

    public DequeOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
