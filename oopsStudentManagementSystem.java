
import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    // Display student details
    public void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

// School class
class School {
    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Remove student by ID
    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student removed successfully!");
    }

    // Display all students
    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("Student List:");
            for (Student s : students) {
                s.displayStudent();
            }
        }
    }
}

// Main class
public class oopsStudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Show All Students\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    school.addStudent(new Student(id, name, age, grade));
                    break;

                case 2:
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = scanner.nextInt();
                    school.removeStudent(removeId);
                    break;

                case 3:
                    school.showStudents();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
