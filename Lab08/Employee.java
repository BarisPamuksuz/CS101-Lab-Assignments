/**
 * @author Barış Pamuksuz 22202238
 * Lab08 CS101
 */

public class Employee {

    public static final int WORKING_DAYS = 261;

    String employeeName;
    double dailyRate;
    department Department;
    project Project;

    public Employee(String employeeName, double dailyRate, project pro, String deptName, String deptCode) {
        this.employeeName = employeeName;
        this.dailyRate = setdailyRate(dailyRate);
        Project = pro;
        Department = new department(deptName, deptCode);
    }

    public Employee(Employee employee) {
        this.employeeName = employee.employeeName;
        this.dailyRate = employee.dailyRate;
        this.Project = employee.Project;
        this.Department = new department(employee.Department.deptName, employee.Department.deptCode);
    }

    // writing accessor methods.
    public String getName() {
        return employeeName;
    }

    public department getDepartment() {
        return Department;
    }

    public project getProject() {
        return Project;
    }

    // writing mutator methods.
    public double setdailyRate(double newRate) {
        if (newRate > 0) {
            dailyRate = newRate;
        } else {
            dailyRate = 0;
        }
        return dailyRate;
    }

    public double calculateYearlySalary() {
        double salary = (WORKING_DAYS * dailyRate) * 10 / 10.0;
        return salary;
    }

    public String toString() {
        double salary = calculateYearlySalary();
        String employeeDis = "Employee Name: " + employeeName + " Yearly Salary: " + salary;
        System.out.println("Employee Name: " + employeeName + " Yearly Salary: " + salary);
        return employeeDis;
    }

}
