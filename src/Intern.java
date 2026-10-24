/**
 * Interns: 6 days a year, up to 2 days per request.
 */
public class Intern extends Employee {

    private static final int ANNUAL_ENTITLEMENT = 6;
    private static final int MAX_DAYS_PER_REQUEST = 2;

    public Intern(int employeeId, String employeeName, String department) {
        super(employeeId, employeeName, department, ANNUAL_ENTITLEMENT);
    }

    @Override
    public String getEmployeeType() {
        return "Intern";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }
}
