public class Manager extends Employee {
    private int bonusLeaveDays = 5;

    public Manager(int id, String name, String dept) {
        super(id, name, dept, 35);   // 30 base days + 5 bonus days
    }

    @Override
    public void applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days.");
            return;
        }
        if (d > 15) {
            System.out.println(getEmployeeName() + ": managers can take at most 15 days at a time.");
            return;
        }
        if (d > checkLeaveBalance()) {
            System.out.println(getEmployeeName() + ": insufficient leave balance.");
            return;
        }
        deduct(d);
        System.out.println(getEmployeeName() + " (Manager) leave approved for " + d + " day(s).");
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("   Bonus leave days: " + bonusLeaveDays);
    }
}
