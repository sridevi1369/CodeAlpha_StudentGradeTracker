import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Number of subjects: ");
            int numSubjects = scanner.nextInt();

            int[] marks = new int[numSubjects];
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter mark for subject " + (j + 1) + ": ");
                marks[j] = scanner.nextInt();
            }

            scanner.nextLine(); // consume newline
            Student student = new Student(name, marks);
            students.add(student);
        }

        // Display summary report
        System.out.println("\n📋 Student Summary Report");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s\n", "Name", "Average", "Grade", "Highest", "Lowest");
        System.out.println("--------------------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-15s %-10.2f %-10s %-10d %-10d\n",
                    student.name,
                    student.calculateAverage(),
                    student.getGrade(),
                    student.getHighestMark(),
                    student.getLowestMark()
            );
        }

        scanner.close();
    }
}