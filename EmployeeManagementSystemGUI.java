import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementSystemGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextArea displayArea;

    public EmployeeManagementSystemGUI() {
        frame = new JFrame("Employee Management System");
        panel = new JPanel();
        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);

        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add employee functionality (to be implemented)
                String[] options = {"Full-Time", "Part-Time", "Contractor"};
                int choice = JOptionPane.showOptionDialog(null, "Select Employee Type", "Add Employee",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (choice != -1) {
                    addEmployee(choice);
                }
            }
        });

        panel.add(addButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void displayEmployeeDetails(Employee employee) {
        displayArea.append(employee.getName() + " - " + employee.getEmployeeId() + "\n");
        employee.displayDetails();
    }

    private void addEmployee(int type) {
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField extraField1 = new JTextField();
        JTextField extraField2 = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Employee ID:"));
        panel.add(idField);
        panel.add(new JLabel("Salary:"));
        panel.add(salaryField);

        if (type == 0) {
            panel.add(new JLabel("Annual Bonus:"));
            panel.add(extraField1);
        } else if (type == 1) {
            panel.add(new JLabel("Hourly Rate:"));
            panel.add(extraField1);
            panel.add(new JLabel("Hours Worked:"));
            panel.add(extraField2);
        } else if (type == 2) {
            panel.add(new JLabel("Contract Period:"));
            panel.add(extraField1);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Employee Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String employeeId = idField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            if (type == 0) {
                double annualBonus = Double.parseDouble(extraField1.getText());
                FullTimeEmployee ftEmployee = new FullTimeEmployee(name, employeeId, salary, annualBonus);
                displayEmployeeDetails(ftEmployee);
            } else if (type == 1) {
                double hourlyRate = Double.parseDouble(extraField1.getText());
                int hoursWorked = Integer.parseInt(extraField2.getText());
                PartTimeEmployee ptEmployee = new PartTimeEmployee(name, employeeId, salary, hourlyRate, hoursWorked);
                displayEmployeeDetails(ptEmployee);
            } else if (type == 2) {
                String contractPeriod = extraField1.getText();
                Contractor contractor = new Contractor(name, employeeId, salary, contractPeriod);
                displayEmployeeDetails(contractor);
            }
        }
    }

    public static void main(String[] args) {
        new EmployeeManagementSystemGUI();
    }
}
