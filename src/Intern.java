public class Intern extends Employee {

    public Intern(int id, String name, String dept) {
        super(id, name, dept, 6);
    }

    @Override
    public void applyLeave(int d) {
        if (d <= 0) {
            System.out.println("Invalid number of days.");
            return;
        }
        if (d > 2) {
            System.out.println(getEmployeeName() + ": interns can take at most 2 days at a time.");
            return;
        }
        if (d > checkLeaveBalance()) {
            System.out.println(getEmployeeName() + ": insufficient leave balance.");
            return;
        }
        deduct(d);
        System.out.println(getEmployeeName() + " (Intern) leave approved for " + d + " day(s).");
    }

    @Override
    public String getEmployeeType() {
        return "Intern";
    }
}
