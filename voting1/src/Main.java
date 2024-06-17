
import controller.AdminController;
import controller.CECController;
import controller.CandidateController;
import controller.UserController;
import model.Candidate;
import model.Administrator;
import model.CEC;
import model.Election;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Main {
        private static List<User> users = new ArrayList<>();
        private static List<Candidate> candidates = new ArrayList<>();
        private static List<CEC> cecs = new ArrayList<>();
        private static List<Election> elections = new ArrayList<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Initial data setup: creating an admin user and a candidate
            Administrator admin = new Administrator("Admin", "1970-01-01", "admin1", "admin", "password");
            users.add(admin);

            // Adding a candidate
            Candidate candidate = new Candidate("John Doe", "1990-01-01", "candidate1", "candidate", "password");
            candidates.add(candidate);

            while (true) {
                System.out.println("Enter your unique ID:");
                String uniqueId = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();

                User user = getUser(uniqueId, password);
                if (user != null) {
                    switch (user.getRole()) {
                        case "Administrator":
                            AdminController adminController = new AdminController();
                            adminController.mainMenu((Administrator) user);
                            break;
                        case "CEC":
                            CECController cecController = new CECController();
                            cecController.mainMenu((CEC) user);
                            break;
                        case "Candidate":
                            CandidateController candidateController = new CandidateController();
                            candidateController.mainMenu((Candidate) user);
                            break;
                        case "User":
                            UserController userController = new UserController();
                            userController.mainMenu(user);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + user.getRole());
                    }
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            }
        }

        // Method to authenticate user based on unique ID and password
        private static User getUser(String uniqueId, String password) {
            for (User user : users) {
                if (user.getUniqueId().equals(uniqueId) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }
    }
