/**
 * Managers are full-time employees with extra benefits:
 * 30 base days plus 5 bonus days a year, and up to 15 days per request.
 * Only what differs from FullTimeEmployee is written here.
 */
public class Manager extends FullTimeEmployee {

    private static final int BASE_ENTITLEMENT = 30;
    private static final int BONUS_LEAVE_DAYS = 5;
    private static final int MAX_DAYS_PER_REQUEST = 15;

    public Manager(int employeeId, String employeeName, String department) {
        super(employeeId, employeeName, department, BASE_ENTITLEMENT + BONUS_LEAVE_DAYS);
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }

    public int getBonusLeaveDays() {
        return BONUS_LEAVE_DAYS;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("   Bonus leave days (manager benefit): " + BONUS_LEAVE_DAYS);
    }
}
