import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sm.addStudent();
                    break;
                case 2:
                    sm.displayStudents();
                    break;
                case 3:
                    sm.searchByPrn();
                    break;
                case 4:
                    sm.searchByName();
                    break;
                case 5:
                    sm.updateStudent();
                    break;
                case 6:
                    sm.deleteStudent();
                    break;
                case 7:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
