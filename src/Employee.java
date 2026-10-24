/**
 * Stage 2: Employee becomes abstract. Each employee type decides its own leave rule.
 */
public abstract class Employee {
    private final int employeeId;
    private String employeeName;
    private String department;
    private int leaveBalance;
    private int leaveTaken;

    public Employee(int employeeId, String employeeName, String department, int leaveBalance) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.leaveBalance = leaveBalance;
    }

    // Abstraction: every type must define its own rule and its own label
    public abstract void applyLeave(int d);

    public abstract String getEmployeeType();

    // Overloading: same name, different parameters
    public void applyLeave(int d, String reason) {
        applyLeave(d);
        System.out.println("   Reason: " + reason);
    }

    public void cancelLeave(int d) {
        if (d <= 0 || d > leaveTaken) {
            System.out.println("Cannot cancel " + d + " day(s).");
            return;
        }
        leaveBalance += d;
        leaveTaken -= d;
        System.out.println(employeeName + " cancelled " + d + " day(s). Balance: " + leaveBalance);
    }

    public int checkLeaveBalance() {
        return leaveBalance;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | " + employeeName + " | " + getEmployeeType()
                + " | " + department + " | Balance: " + leaveBalance + " | Taken: " + leaveTaken);
    }

    // protected: only subclasses should change the balance directly
    protected void deduct(int d) {
        leaveBalance -= d;
        leaveTaken += d;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
