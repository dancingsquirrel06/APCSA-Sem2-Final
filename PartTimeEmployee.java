public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String employeeId, double salary, double hourlyRate, int hoursWorked) {
        super(name, employeeId, salary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void displayDetails() {
        System.out.println("Part-Time Employee: " + getName() + ", ID: " + getEmployeeId() + ", Salary: " + getSalary() + ", Hourly Rate: " + hourlyRate + ", Hours Worked: " + hoursWorked);
    }
}
