package controller;

import model.User;

import java.util.Scanner;

public class UserController {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu(User user) {
        while (true) {
            System.out.println("=== User Menu ===");
            System.out.println("1. Register");
            System.out.println("2. Vote");
            System.out.println("3. View Candidates");
            System.out.println("4. View Voting History");
            System.out.print("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implement method to register
                    break;
                case 2:
                    // Implement method to vote
                    break;
                case 3:
                    // Implement method to view candidates
                    break;
                case 4:
                    // Implement method to view voting history
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}
