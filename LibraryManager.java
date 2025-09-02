import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {

    private ArrayList<String> bookList;
    private Scanner input;

    public LibraryManager() {
        bookList = new ArrayList<>();
        input = new Scanner(System.in);

        bookList.add("Code sa Hapon");
        bookList.add("CSS sa Mars");
        bookList.add("Loving You in SQL");
    }

    public void showBooks() {
        try {
            if (bookList == null) {
                throw new IllegalStateException("Book list is not initialized.");
            }

            if (bookList.isEmpty()) {
                System.out.println("The library is currently empty.");
            } else {
                System.out.println("\nCurrent Books in the Library:");
                for (int i = 0; i < bookList.size(); i++) {
                    System.out.println((i + 1) + ". " + bookList.get(i));
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Book display completed.\n");
        }
    }

    public void addBook() {
        try {
            System.out.print("Enter the title of the book to add: ");
            String title = input.nextLine();

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be empty.");
            }

            if (title.trim().length() < 3) {
                throw new IllegalArgumentException("Book title must be at least 3 characters long.");
            }

            bookList.add(title.trim());
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Add book operation completed.");
            showBooks();
        }
    }

    public void removeBook() {
        try {
            if (bookList.isEmpty()) {
                System.out.println("Cannot remove from an empty library.");
                return;
            }

            System.out.print("Enter the index of the book to remove (1 to " + bookList.size() + "): ");
            String inputStr = input.nextLine();
            int index = Integer.parseInt(inputStr) - 1;

            if (index < 0) {
                throw new IllegalArgumentException("Index cannot be negative.");
            }

            String removed = bookList.remove(index);
            System.out.println("Removed book: " + removed);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index. No book at that position.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Remove book operation completed.");
            showBooks();
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        
        manager.showBooks();
        manager.addBook();
        manager.removeBook();
    }
}
