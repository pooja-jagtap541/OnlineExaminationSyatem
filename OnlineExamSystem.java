package onlineExam;

import java.util.Scanner;

public class OnlineExamSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("pooja123", "pass123", "Pooja Jagtap", "pooja@email.com");

        System.out.println("===== 🧑‍💻 Online Examination System =====");

        System.out.print("Enter Username: ");
        String uname = sc.next();
        System.out.print("Enter Password: ");
        String pwd = sc.next();

        if (!user.login(uname, pwd)) {
            System.out.println("❌ Invalid login credentials.");
            return;
        }

        System.out.println("✅ Login successful!\n");

        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String name = sc.next();
                    System.out.print("Enter new email: ");
                    String email = sc.next();
                    user.updateProfile(name, email);
                    break;

                case 2:
                    System.out.print("Enter old password: ");
                    String oldPass = sc.next();
                    System.out.print("Enter new password: ");
                    String newPass = sc.next();
                    user.updatePassword(oldPass, newPass);
                    break;

                case 3:
                    Exam exam = new Exam();
                    exam.startExam();
                    break;

                case 4:
                    System.out.println("🚪 Logged out. Session closed.");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
