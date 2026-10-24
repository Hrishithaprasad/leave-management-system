import java.util.ArrayList;
import java.util.List;

/**
 * Base class for every employee type.
 *
 * Abstraction: subclasses only say WHAT is different (their label and their
 * per-request limit). The shared steps for applying and cancelling leave
 * live here once, so no subclass repeats them.
 */
public abstract class Employee {

    // Encapsulation: all state is private and changed only through methods
    private final int employeeId;
    private final String employeeName;
    private final String department;
    private int leaveBalance;
    private int leaveTaken;
    private final List<LeaveRecord> leaveHistory = new ArrayList<>();

    protected Employee(int employeeId, String employeeName, String department, int annualEntitlement) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
        if (employeeName == null || employeeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name must not be blank.");
        }
        this.employeeId = employeeId;
        this.employeeName = employeeName.trim();
        this.department = department;
        this.leaveBalance = annualEntitlement;
    }

    // ---- Rules that differ by employee type (implemented by subclasses) ----

    public abstract String getEmployeeType();

    protected abstract int getMaxDaysPerRequest();

    // ---- Leave operations ----

    // Method overloading: same name, different parameter lists
    public void applyLeave(int days) throws LeaveException {
        applyLeave(days, "Not specified");
    }

    public void applyLeave(int days, String reason) throws LeaveException {
        validateRequest(days);
        leaveBalance -= days;
        leaveTaken += days;
        leaveHistory.add(new LeaveRecord(LeaveRecord.Action.APPLIED, days, reason));
    }

    public void cancelLeave(int days) throws InvalidLeaveRequestException {
        if (days <= 0) {
            throw new InvalidLeaveRequestException("Days to cancel must be greater than zero.");
        }
        if (days > leaveTaken) {
            throw new InvalidLeaveRequestException("Cannot cancel " + days + " day(s); only "
                    + leaveTaken + " day(s) have been taken.");
        }
        leaveBalance += days;
        leaveTaken -= days;
        leaveHistory.add(new LeaveRecord(LeaveRecord.Action.CANCELLED, days, "Cancelled by employee"));
    }

    public int checkLeaveBalance() {
        return leaveBalance;
    }

    public void displayDetails() {
        System.out.printf("ID: %d | %s | %s | %s%n",
                employeeId, employeeName, getEmployeeType(), department);
        System.out.printf("   Leave balance: %d | Leave taken: %d | Max per request: %d%n",
                leaveBalance, leaveTaken, getMaxDaysPerRequest());
    }

    public void displayLeaveHistory() {
        System.out.println("Leave history for " + employeeName + ":");
        if (leaveHistory.isEmpty()) {
            System.out.println("   (no leave activity)");
        }
        for (LeaveRecord record : leaveHistory) {
            System.out.println("   - " + record);
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    // ---- Private helper: the one place where every request is checked ----

    private void validateRequest(int days) throws LeaveException {
        if (days <= 0) {
            throw new InvalidLeaveRequestException("Leave days must be greater than zero.");
        }
        if (days > getMaxDaysPerRequest()) {
            throw new InvalidLeaveRequestException(getEmployeeType() + " employees can take at most "
                    + getMaxDaysPerRequest() + " day(s) per request.");
        }
        if (days > leaveBalance) {
            throw new InsufficientLeaveBalanceException(days, leaveBalance);
        }
    }
}
