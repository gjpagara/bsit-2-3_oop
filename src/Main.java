import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = input.nextInt();
            total += num;
        }

        System.out.println("Total Number: " + total);

        input.close();
    }
}
