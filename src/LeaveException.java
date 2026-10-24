/**
 * Base class for every error raised by the leave rules.
 * Checked on purpose: callers must decide how to handle a rejected request.
 */
public class LeaveException extends Exception {

    public LeaveException(String message) {
        super(message);
    }
}
