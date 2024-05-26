public class Contractor extends Employee {
    private String contractPeriod;

    public Contractor(String name, String employeeId, double salary, String contractPeriod) {
        super(name, employeeId, salary);
        this.contractPeriod = contractPeriod;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    @Override
    public void displayDetails() {
        System.out.println("Contractor: " + getName() + ", ID: " + getEmployeeId() + ", Salary: " + getSalary() + ", Contract Period: " + contractPeriod);
    }
}
