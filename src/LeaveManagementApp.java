/**
 * Scripted console demo. It runs the same steps every time, so the output
 * can be compared with the screenshots. All printing of results happens here;
 * the employee classes only apply the rules and throw exceptions.
 */
public class LeaveManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Leave Management System ===");

        // Polymorphism: one array holds every employee type
        Employee[] staff = {
            new FullTimeEmployee(101, "Anita Rao", "Engineering"),
            new PartTimeEmployee(102, "Ravi Kumar", "HR"),
            new Intern(103, "Meera Nair", "Finance"),
            new Manager(104, "Karthik Iyer", "Operations")
        };

        printHeading("1. Employee details");
        for (Employee employee : staff) {
            employee.displayDetails();
        }

        Employee anita = staff[0];
        Employee ravi = staff[1];
        Employee meera = staff[2];
        Employee karthik = staff[3];

        printHeading("2. Applying leave (each type follows its own rule)");
        applyLeave(anita, 5, "Family function");
        applyLeave(ravi, 3, "Medical appointment");
        applyLeave(meera, 2);
        applyLeave(karthik, 12, "Annual vacation");

        printHeading("3. Same request, different rules: everyone asks for 8 days");
        for (Employee employee : staff) {
            applyLeave(employee, 8, "Long break");
        }

        printHeading("4. Edge cases");
        applyLeave(anita, 0, "Zero days");
        applyLeave(anita, -3, "Negative days");
        applyLeave(meera, 2, "Second request");
        applyLeave(meera, 2, "Third request");
        applyLeave(meera, 1, "Balance already used up");
        cancelLeave(ravi, 1);
        cancelLeave(ravi, 10);
        createEmployeeWithBlankName();

        printHeading("5. Leave balances");
        for (Employee employee : staff) {
            System.out.println(employee.getEmployeeName() + " (" + employee.getEmployeeType()
                    + "): " + employee.checkLeaveBalance() + " day(s) left");
        }

        printHeading("6. Leave history");
        karthik.displayLeaveHistory();
        ravi.displayLeaveHistory();
    }

    // Overloaded helpers keep the demo short and show overloading in use
    private static void applyLeave(Employee employee, int days) {
        try {
            employee.applyLeave(days);
            System.out.println("OK    " + employee.getEmployeeName() + " took " + days + " day(s).");
        } catch (LeaveException e) {
            System.out.println("DENIED " + employee.getEmployeeName() + ": " + e.getMessage());
        }
    }

    private static void applyLeave(Employee employee, int days, String reason) {
        try {
            employee.applyLeave(days, reason);
            System.out.println("OK    " + employee.getEmployeeName() + " took " + days
                    + " day(s) (" + reason + ").");
        } catch (LeaveException e) {
            System.out.println("DENIED " + employee.getEmployeeName() + ": " + e.getMessage());
        }
    }

    private static void cancelLeave(Employee employee, int days) {
        try {
            employee.cancelLeave(days);
            System.out.println("OK    " + employee.getEmployeeName()
                    + " cancelled " + days + " day(s).");
        } catch (LeaveException e) {
            System.out.println("DENIED " + employee.getEmployeeName() + ": " + e.getMessage());
        }
    }

    private static void createEmployeeWithBlankName() {
        try {
            new Intern(105, "   ", "Finance");
        } catch (IllegalArgumentException e) {
            System.out.println("REJECTED new employee: " + e.getMessage());
        }
    }

    private static void printHeading(String title) {
        System.out.println();
        System.out.println("--- " + title + " ---");
    }
}
