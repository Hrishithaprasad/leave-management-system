public class LeaveManagementApp {
    public static void main(String[] args) {
        // Polymorphism: one array holds every employee type
        Employee[] staff = {
            new FullTimeEmployee(101, "Anita Rao", "Engineering"),
            new PartTimeEmployee(102, "Ravi Kumar", "HR"),
            new Intern(103, "Meera Nair", "Finance"),
            new Manager(104, "Karthik Iyer", "Operations")
        };

        for (Employee emp : staff) {
            emp.displayDetails();
        }

        System.out.println("-- Everyone applies for 8 days --");
        for (Employee emp : staff) {
            emp.applyLeave(8);
        }

        staff[0].applyLeave(3, "Family function");
        staff[1].applyLeave(2);
        staff[2].applyLeave(2);
        staff[1].cancelLeave(1);

        for (Employee emp : staff) {
            System.out.println(emp.getEmployeeName() + " balance: " + emp.checkLeaveBalance());
        }
    }
}
