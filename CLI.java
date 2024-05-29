import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) { //main method for running CLI
        Scanner scanner = new Scanner(System.in); //scanner for user input

        while (true) { //while loop to keep CLI running
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Exit");
            int choice = scanner.nextInt(); //read user choice

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private static void addEmployee(Scanner scanner) { //method to add new employee
        System.out.println("Enter type (1: Full-Time, 2: Part-Time, 3: Contractor):");
        int type = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee ID:");
        String employeeId = scanner.nextLine();

        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();

        switch (type) { //create specific employee type
            case 1:
                System.out.println("Enter annual bonus:");
                double annualBonus = scanner.nextDouble();
                employees.add(new FullTimeEmployee(name, employeeId, salary, annualBonus));
                break;
            case 2:
                System.out.println("Enter hourly rate:");
                double hourlyRate = scanner.nextDouble();
                System.out.println("Enter hours worked:");
                int hoursWorked = scanner.nextInt();
                employees.add(new PartTimeEmployee(name, employeeId, salary, hourlyRate, hoursWorked));
                break;
            case 3:
                System.out.println("Enter contract period:");
                String contractPeriod = scanner.next();
                employees.add(new Contractor(name, employeeId, salary, contractPeriod));
                break;
        }
    }

    private static void displayEmployees() { //method to display all employees
        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }
}
