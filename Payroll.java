import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {

        // Open the Employee Database file
        try (BufferedReader fileReader = new BufferedReader(new FileReader("MotorPHEmployeeData2.csv"))) {
    
            // Create a CSV reader object
            String line;
            String[] header = null;
            Map<String, Map<String, String>> employees = new HashMap<>();
    
            // Read the header row
            if ((line = fileReader.readLine()) != null) {
                header = line.split(",");
            }
    
            // Iterate over each row in the file
            while ((line = fileReader.readLine()) != null) {
                String[] row = line.split(",");
    
                // Extract the employee information from the row
                String employeeId = row[0];
                String lastName = row[1];
                String firstName = row[2];
                String payroll = row[21];
    
                // Add the employee information to the employees map
                Map<String, String> employeeData = new HashMap<>();
                employeeData.put("LastName", lastName);
                employeeData.put("FirstName", firstName);
                employeeData.put("Payroll", payroll);
                employees.put(employeeId, employeeData);
            }
    
            // Prompt the user to enter an employee ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an employee ID to view their Payroll: ");
            String employeeId = scanner.nextLine();
    
            // Check if the employee ID is valid
            if (!employees.containsKey(employeeId)) {
                System.out.println("Invalid employee ID.");
            } else {
                // Display the employee information
                System.out.println("Employee ID: " + employeeId);
                System.out.println("LastName: " + employees.get(employeeId).get("LastName"));
                System.out.println("FirstName: " + employees.get(employeeId).get("FirstName"));
                System.out.println("Payroll: " + employees.get(employeeId).get("Payroll"));
            }
    
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}    