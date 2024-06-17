package controller;

import model.Administrator;

import java.util.Scanner;

public class AdminController {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu(Administrator admin) {
        while (true) {
            System.out.println("=== Administrator Menu ===");
            System.out.println("1. View and Manage Users");
            System.out.println("2. View and Manage CECs");
            System.out.println("3. Create a CEC");
            System.out.println("4. View and Manage Candidates");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implement method to view and manage users
                    break;
                case 2:
                    // Implement method to view and manage CECs
                    break;
                case 3:
                    // Implement method to create a CEC
                    break;
                case 4:
                    // Implement method to view and manage candidates
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

}
