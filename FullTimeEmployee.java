public class FullTimeEmployee extends Employee {
    private double annualBonus;

    public FullTimeEmployee(String name, String employeeId, double salary, double annualBonus) {
        super(name, employeeId, salary);
        this.annualBonus = annualBonus;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    @Override
    public void displayDetails() {
        System.out.println("Full-Time Employee: " + getName() + ", ID: " + getEmployeeId() + ", Salary: " + getSalary() + ", Annual Bonus: " + annualBonus);
    }
}
