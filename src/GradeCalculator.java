import java.util.Arrays;

public class GradeCalculator {

    private static final double PASSING_GRADE = 60.0;

    public double calculateAverage(double... grades) {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }
        return Arrays.stream(grades).average().orElse(0.0);
    }

    public String getLetterGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= PASSING_GRADE) return "D";
        return "F";
    }

    public void displayResult(String studentName, double average) {
        System.out.printf("Student: %s, Average: %.2f%n", studentName, average);
    }

    public void displayResult(String studentName, double average, String letterGrade) {
        System.out.printf("Student: %s, Average: %.2f, Grade: %s%n", studentName, average, letterGrade);
    }
}
