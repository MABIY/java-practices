package validating;

/**
 * @author lh
 */
public class CircularQueueException extends RuntimeException{
    public CircularQueueException(String message) {
        super(message);
    }
}
