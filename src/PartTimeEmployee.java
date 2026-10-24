public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(int id, String name, String dept) {
        super(id, name, dept, 12);
    }

    @Override
    public void applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days.");
            return;
        }
        if (d > 5) {
            System.out.println(getEmployeeName() + ": part-time employees can take at most 5 days at a time.");
            return;
        }
        if (d > checkLeaveBalance()) {
            System.out.println(getEmployeeName() + ": insufficient leave balance.");
            return;
        }
        deduct(d);
        System.out.println(getEmployeeName() + " (Part-Time) leave approved for " + d + " day(s).");
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }
}
