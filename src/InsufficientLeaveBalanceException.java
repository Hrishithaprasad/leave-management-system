/**
 * Thrown when an employee asks for more days than their remaining balance.
 */
public class InsufficientLeaveBalanceException extends LeaveException {
    private final int requestedDays;
    private final int availableDays;

    public InsufficientLeaveBalanceException(int requestedDays, int availableDays) {
        super("Requested " + requestedDays + " day(s) but only " + availableDays + " available.");
        this.requestedDays = requestedDays;
        this.availableDays = availableDays;
    }

    public int getRequestedDays() {
        return requestedDays;
    }

    public int getAvailableDays() {
        return availableDays;
    }
}
