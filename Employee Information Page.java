import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDatabase {

    public static void main(String[] args) throws IOException {
        Map<String, String[]> employees = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("MotorPHEmployeeData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                employees.put(data[0], data);
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an employee ID to view their information: ");
        String employee_id = input.nextLine();
        if (!employees.containsKey(employee_id)) {
            System.out.println("Invalid employee ID.");
        } else {
            String[] employeeData = employees.get(employee_id);
            System.out.println("Employee ID: " + employee_id);
            System.out.println("LastName: " + employeeData[1]);
            System.out.println("FirstName: " + employeeData[2]);
            System.out.println("Birthday: " + employeeData[3]);
            System.out.println("Position: " + employeeData[11]);
        }
    }
}
