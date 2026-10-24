/**
 * Full-time employees: 24 days a year, up to 10 days per request.
 */
public class FullTimeEmployee extends Employee {

    private static final int ANNUAL_ENTITLEMENT = 24;
    private static final int MAX_DAYS_PER_REQUEST = 10;

    public FullTimeEmployee(int employeeId, String employeeName, String department) {
        this(employeeId, employeeName, department, ANNUAL_ENTITLEMENT);
    }

    // protected: lets a subclass such as Manager reuse this class with its own entitlement
    protected FullTimeEmployee(int employeeId, String employeeName, String department,
                               int annualEntitlement) {
        super(employeeId, employeeName, department, annualEntitlement);
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }
}
