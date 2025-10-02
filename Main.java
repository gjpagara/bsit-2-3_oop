public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        System.out.println("=== LIBRARY MANAGEMENT SYSTEM TEST ===");

        System.out.println("\n=== Adding Items to Library ===");

        Book book1 = new Book("B101", "Java Programming", "James Gosling", "1234567890", 600, "Programming");
        manager.addItem(book1);
        System.out.println("Added: Book - " + book1.title + " by " + book1.author);

        Magazine mag1 = new Magazine("M201", "Tech Today", "Editor Smith", 75, "October", true);
        manager.addItem(mag1);
        System.out.println("Added: Magazine - " + mag1.title + " by " + mag1.author);

        DVD dvd1 = new DVD("D301", "The Matrix", "Wachowski Sisters", 136, "R", "Sci-Fi");
        manager.addItem(dvd1);
        System.out.println("Added: DVD - " + dvd1.title + " by " + dvd1.author);

        System.out.println("\n=== Displaying All Items ===");
        manager.displayAllItemsFormatted();

        Student student = new Student("S001", "John Smith", "john@example.com", "ST123", "Computer Science");
        Faculty faculty = new Faculty("F001", "Dr. Smith", "drsmith@example.edu", "Engineering", "Professor");

        System.out.println("\n=== Testing Borrowing ===");
        manager.borrowItem("B101", student);
        manager.borrowItem("D301", faculty);

        System.out.println("\n=== Displaying Available Items ===");
        manager.displayAvailableItemsFormatted();

        System.out.println("\n=== Testing Late Fees ===");
        int daysLateForBook = 5;
        System.out.println(book1.title + " - " + daysLateForBook + " days late: $" + String.format("%.2f", book1.calculateLateFee(daysLateForBook)));

        int daysLateForDVD = 3;
        System.out.println(dvd1.title + " - " + daysLateForDVD + " days late: $" + String.format("%.2f", dvd1.calculateLateFee(daysLateForDVD)));

        System.out.println("\n=== Testing User Information ===");
        System.out.println("Student: " + student.getName() + " (" + student.getMajor() + ") - " + student.getBorrowedItemsCount() + " items borrowed");
        System.out.println("Faculty: " + faculty.getName() + " (" + faculty.getDepartment() + ") - " + faculty.getBorrowedItemsCount() + " items borrowed");

    }
}
