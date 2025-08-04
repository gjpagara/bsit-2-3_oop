public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Chronicles of Jupeta", "Jupeta", 150);
        Book book2 = new Book("Dog Eater", "Jupeta", 180);
        Book book3 = new Book("Unicorn", "Jupeta", 160);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        book1.borrowBook();
        book1.displayInfo();

        book1.returnBook();
        book1.displayInfo();
    }
}

