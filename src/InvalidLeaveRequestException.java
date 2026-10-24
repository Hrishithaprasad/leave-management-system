/**
 * Thrown when a request breaks a rule: zero or negative days,
 * more days than the employee type allows at once, or a cancellation
 * larger than the leave actually taken.
 */
public class InvalidLeaveRequestException extends LeaveException {

    public InvalidLeaveRequestException(String message) {
        super(message);
    }
}
