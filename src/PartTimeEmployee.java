/**
 * Part-time employees: 12 days a year, up to 5 days per request.
 */
public class PartTimeEmployee extends Employee {

    private static final int ANNUAL_ENTITLEMENT = 12;
    private static final int MAX_DAYS_PER_REQUEST = 5;

    public PartTimeEmployee(int employeeId, String employeeName, String department) {
        super(employeeId, employeeName, department, ANNUAL_ENTITLEMENT);
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }
}
