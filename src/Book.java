public class Book {
    String title;
    String author;
    int pages;
    boolean isAvailable;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
        System.out.println("A new book '" + this.title + "' by " + this.author + " has been added to the library!");
    }

    public void displayInfo() {
        System.out.println("---- Book Info ----");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
        System.out.println();
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book Borrowed\n");
        } else {
            System.out.println("Book is currently not available\n");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book Returned\n");
        } else {
            System.out.println("Book is already available\n");
        }
    }
}
