/**
 * One entry in an employee's leave history.
 * Package-private (no modifier): it is an internal detail of the leave
 * package and is not meant to be used by outside code.
 */
class LeaveRecord {

    enum Action { APPLIED, CANCELLED }

    private final Action action;
    private final int days;
    private final String reason;

    LeaveRecord(Action action, int days, String reason) {
        this.action = action;
        this.days = days;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return action + " " + days + " day(s) - " + reason;
    }
}
