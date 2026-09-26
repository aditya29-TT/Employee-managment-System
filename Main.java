import java.util.List;
import java.util.Scanner;

public class Main {
    private static final EmployeeManager manager = new EmployeeManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> viewEmployees();
                case "3" -> updateEmployee();
                case "4" -> removeEmployee();
                case "5" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.\n");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Employee Management System =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Remove Employee");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addEmployee() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = readDouble();

        System.out.print("Role (1 = Manager, 2 = Developer): ");
        String roleChoice = scanner.nextLine().trim();

        Employee employee;
        if (roleChoice.equals("1")) {
            System.out.print("Team Size: ");
            int teamSize = readInt();
            employee = new Manager(0, name, department, salary, teamSize);
        } else {
            System.out.print("Primary Programming Language: ");
            String lang = scanner.nextLine();
            employee = new Developer(0, name, department, salary, lang);
        }

        int id = manager.addEmployee(employee);
        System.out.println("Employee added with ID: " + id + "\n");
    }

    private static void viewEmployees() {
        List<Employee> all = manager.getAllEmployees();
        if (all.isEmpty()) {
            System.out.println("No employees found.\n");
            return;
        }
        System.out.println("---- Employee List (" + all.size() + ") ----");
        for (Employee e : all) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = readInt();

        if (manager.findById(id).isEmpty()) {
            System.out.println("No employee found with ID " + id + "\n");
            return;
        }

        System.out.print("New Name (leave blank to keep current): ");
        String name = scanner.nextLine();
        System.out.print("New Department (leave blank to keep current): ");
        String department = scanner.nextLine();
        System.out.print("New Salary (enter -1 to keep current): ");
        double salary = readDouble();

        boolean updated = manager.updateEmployee(id, name, department, salary);
        System.out.println(updated ? "Employee updated.\n" : "Update failed.\n");
    }

    private static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = readInt();
        boolean removed = manager.removeEmployee(id);
        System.out.println(removed ? "Employee removed.\n" : "No employee found with that ID.\n");
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, defaulting to 0.");
            return 0;
        }
    }

    private static double readDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, defaulting to 0.");
            return 0;
        }
    }
}