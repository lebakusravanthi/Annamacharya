import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    // HashMap to store student ID and Name
    static HashMap<Integer, String> studentMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    removeStudent(sc);
                    break;
                case 5:
                    System.out.println("Exiting Program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        studentMap.put(id, name);
        System.out.println("Student added successfully.");
    }

    static void displayStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\nStudent List:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        if (studentMap.containsKey(id)) {
            System.out.println("Student Found: " + studentMap.get(id));
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void removeStudent(Scanner sc) {
        System.out.print("Enter Student ID to remove: ");
        int id = sc.nextInt();
        if (studentMap.remove(id) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }
}
