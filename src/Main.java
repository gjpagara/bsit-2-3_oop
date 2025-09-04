public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Smith");
        Book book2 = new Book("Data Structures", "Alice Brown");
        Book book3 = new Book("Web Development", "Bob Wilson");

        try {
            book1.addRating(4);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        book2.addMultipleRatings(5, 4, 3, 5);
        book3.addMultipleRatings(5, 4, 3, 5, 6);

        try {
            book1.addRating(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nBook Results:");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("\nTotal Books created: " + Book.getTotalBooks());

        Book highestRatedBook = findHighestRatedBook(book1, book2, book3);
        System.out.println("Highest rated book: " + highestRatedBook.getTitle() + " by " + highestRatedBook.getAuthor() + " (" + highestRatedBook.getAverageRating() + ")");
    }

    public static Book findHighestRatedBook(Book... books) {
        Book highestRated = books[0];
        for (Book book : books) {
            if (book.getAverageRating() > highestRated.getAverageRating()) {
                highestRated = book;
            }
        }
        return highestRated;
    }
}
