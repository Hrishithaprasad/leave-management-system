public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int id, String name, String dept) {
        super(id, name, dept, 24);
    }

    @Override
    public void applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days.");
            return;
        }
        if (d > 10) {
            System.out.println(getEmployeeName() + ": full-time employees can take at most 10 days at a time.");
            return;
        }
        if (d > checkLeaveBalance()) {
            System.out.println(getEmployeeName() + ": insufficient leave balance.");
            return;
        }
        deduct(d);
        System.out.println(getEmployeeName() + " (Full-Time) leave approved for " + d + " day(s).");
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }
}
