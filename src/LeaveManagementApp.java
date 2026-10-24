public class LeaveManagementApp {
    public static void main(String[] args) {
        FullTimeEmployee anita = new FullTimeEmployee(101, "Anita Rao", "Engineering");
        PartTimeEmployee ravi = new PartTimeEmployee(102, "Ravi Kumar", "HR");
        Intern meera = new Intern(103, "Meera Nair", "Finance");

        anita.displayDetails();
        ravi.displayDetails();
        meera.displayDetails();

        anita.applyLeave(8);
        ravi.applyLeave(8);
        meera.applyLeave(8);

        anita.applyLeave(3, "Family function");
        ravi.applyLeave(2);
        meera.applyLeave(2);
        ravi.cancelLeave(1);

        System.out.println(anita.getEmployeeName() + " balance: " + anita.checkLeaveBalance());
        System.out.println(ravi.getEmployeeName() + " balance: " + ravi.checkLeaveBalance());
        System.out.println(meera.getEmployeeName() + " balance: " + meera.checkLeaveBalance());
    }
}
