public class LeaveManagementApp {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Anita Rao", "Engineering", 20);
        Employee e2 = new Employee(102, "Ravi Kumar", "HR", 15);
        Employee e3 = new Employee(103, "Meera Nair", "Finance", 10);

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
