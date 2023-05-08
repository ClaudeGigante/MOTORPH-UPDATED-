import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private static final String FILE_PATH = "MotorPHEmployeeData.csv";
    private static final String NEW_FILE_PATH = "updated_employee_info.csv";

    public static void main(String[] args) {
        try {
            // Open the CSV file for reading
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));

            // Get the headers
            String[] headers = reader.readLine().split(",");

            // Create a list to store the updated information
            List<String[]> updatedInfo = new ArrayList<>();

            // Create a scanner to get user input
            Scanner scanner = new Scanner(System.in);

            // Loop through each row
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                // Get the employee ID
                String empID = row[0];

                // Display the employee's current information
                System.out.println("Employee ID: " + empID);
                System.out.println("Last Name: " + row[1]);
                System.out.println("First Name: " + row[2]);
                System.out.println("Phone: " + row[5]);
                System.out.println("Address: " + row[4]);
                System.out.println("Birthday: " + row[3]);

                // Prompt the user for updates
                System.out.print("Enter new Last Name (leave blank to keep current): ");
                String lastName = scanner.nextLine();
                System.out.print("Enter new First Name (leave blank to keep current): ");
                String firstName = scanner.nextLine();
                System.out.print("Enter new phone (leave blank to keep current): ");
                String phone = scanner.nextLine();
                System.out.print("Enter new address (leave blank to keep current): ");
                String address = scanner.nextLine();
                System.out.print("Enter new birthday (leave blank to keep current): ");
                String birthday = scanner.nextLine();

                // Add the updated information to the list
                updatedInfo.add(new String[]{empID, lastName.isEmpty() ? row[1] : lastName, firstName.isEmpty() ? row[2] : firstName, row[3], address.isEmpty() ? row[4] : address, phone.isEmpty() ? row[5] : phone});
            }

            // Close the reader and scanner
            reader.close();
            scanner.close();

            // Open the CSV file for writing
            FileWriter writer = new FileWriter(NEW_FILE_PATH);

            // Write the headers
            writer.write(String.join(",", headers) + "\n");

            // Write the updated information
            for (String[] row : updatedInfo) {
                writer.write(String.join(",", row) + "\n");
            }

            // Close the writer
            writer.close();

            System.out.println("Employee information updated successfully!");

        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
