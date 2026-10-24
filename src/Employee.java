/**
 * Stage 1: a single concrete Employee class with the basic leave operations.
 */
public class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private int leaveBalance;
    private int leaveTaken;

    public Employee(int employeeId, String employeeName, String department, int leaveBalance) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.leaveBalance = leaveBalance;
        this.leaveTaken = 0;
    }

    public void applyLeave(int days) {
        if (days <= 0) {
            System.out.println("Invalid number of days.");
            return;
        }
        if (days > leaveBalance) {
            System.out.println("Insufficient leave balance.");
            return;
        }
        leaveBalance -= days;
        leaveTaken += days;
        System.out.println(employeeName + " applied for " + days + " day(s). Balance: " + leaveBalance);
    }

    public void cancelLeave(int days) {
        if (days <= 0 || days > leaveTaken) {
            System.out.println("Cannot cancel " + days + " day(s).");
            return;
        }
        leaveBalance += days;
        leaveTaken -= days;
        System.out.println(employeeName + " cancelled " + days + " day(s). Balance: " + leaveBalance);
    }

    public int checkLeaveBalance() {
        return leaveBalance;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName
                + " | Department: " + department
                + " | Leave Balance: " + leaveBalance + " | Leave Taken: " + leaveTaken);
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
