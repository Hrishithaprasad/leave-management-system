/**
 * Stage 1a: the Employee class with its data and a way to display it.
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

    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName
                + " | Department: " + department
                + " | Leave Balance: " + leaveBalance + " | Leave Taken: " + leaveTaken);
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
