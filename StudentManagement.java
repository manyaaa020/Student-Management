import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentManagement {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add Student
    public void addStudent() {
        System.out.print("Enter PRN: ");
        String prn = scanner.next();

        System.out.print("Enter Name: ");
        scanner.nextLine(); // Consume leftover newline
        String name = scanner.nextLine();

        System.out.print("Enter DOB (dd-MM-yyyy): ");
        String dobStr = scanner.next();

        scanner.nextLine(); // Consume newline before reading marks

        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter numeric marks.");
            scanner.next(); // Clear invalid input
        }
        double marks = scanner.nextDouble();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = sdf.parse(dobStr);
            students.add(new Student(prn, name, dob, marks));
            System.out.println("Student added successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Use dd-MM-yyyy.");
        }
    }

    // Display All Students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    // Search by PRN
    public void searchByPrn() {
        System.out.print("Enter PRN to search: ");
        String prn = scanner.next();
        for (Student s : students) {
            if (s.getPrn().equals(prn)) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search by Name
    public void searchByName() {
        System.out.print("Enter Name to search: ");
        scanner.nextLine(); // Consume leftover newline
        String name = scanner.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }

    // Update Student
    public void updateStudent() {
        System.out.print("Enter PRN to update: ");
        String prn = scanner.next();
        for (Student s : students) {
            if (s.getPrn().equals(prn)) {
                System.out.print("Enter new Name: ");
                scanner.nextLine(); // Consume newline
                s.setName(scanner.nextLine());

                System.out.print("Enter new Marks: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input! Please enter numeric marks.");
                    scanner.next();
                }
                s.setMarks(scanner.nextDouble());

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent() {
        System.out.print("Enter PRN to delete: ");
        String prn = scanner.next();
        boolean removed = students.removeIf(s -> s.getPrn().equals(prn));
        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}
