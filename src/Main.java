import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        if (studentName.trim().isEmpty()) {
            studentName = "Juan Dela Cruz";
        }

        System.out.print("Enter grades separated by spaces: ");
        String[] inputGrades = scanner.nextLine().split(" ");
        double[] grades = new double[inputGrades.length];

        try {
            for (int i = 0; i < inputGrades.length; i++) {
                grades[i] = Double.parseDouble(inputGrades[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric grades only.");
            scanner.close();
            return;
        }

        double average = calculator.calculateAverage(grades);
        String letterGrade = calculator.getLetterGrade(average);

        calculator.displayResult(studentName, average);
        calculator.displayResult(studentName, average, letterGrade);

        scanner.close();
    }
}
