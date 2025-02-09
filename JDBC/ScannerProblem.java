import java.util.Scanner;

public class ScannerProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();  // Reads integer but leaves newline (\n)

        // scanner.nextLine();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  // This will be skipped! 😲

        System.out.println("Name: " + name + ", Age: " + age);
        scanner.close();
    }
}
