package controller;
import model.Candidate;

import java.util.Scanner;

public class CandidateController {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu(Candidate candidate) {
        while (true) {
            System.out.println("=== Candidate Menu ===");
            System.out.println("1. Fill in Details");
            System.out.println("2. View Previous Voting Results");
            System.out.println("3. View Participation History");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implement method to fill in candidate details
                    break;
                case 2:
                    // Implement method to view previous voting results
                    break;
                case 3:
                    // Implement method to view participation history
                    break;
                case 4:
                    return;
                default:System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}

