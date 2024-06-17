package controller;

import model.CEC;

import java.util.Scanner;

public class CECController {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu(CEC cec) {
        while (true) {
            System.out.println("=== CEC Menu ===");
            System.out.println("1. Create a Voting");
            System.out.println("2. Add Candidates");
            System.out.println("3. Print Results (PDF)");
            System.out.println("4. Select Result Grouping");
            System.out.println("5. Sort Results");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implement method to create a voting
                    break;
                case 2:
                    // Implement method to add candidates
                    break;
                case 3:
                    // Implement method to print results in PDF
                    break;
                case 4:
                    // Implement method to select result grouping
                    break;
                case 5:
                    // Implement method to sort results
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}
