import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String username = "ClaudeGigante";
            String password = "GiganteClaude";

            System.out.print("Enter username: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = input.nextLine();

            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect username or password");
            }
        }
    }
}