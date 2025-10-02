public abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isCheckedOut;
    protected String borrowerName; 

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public String getItemInfo() {
        return String.format("ID: %s | Title: %s | Author: %s | Type: %s",
                itemId, title, author, getItemType());
    }

    public void checkOut(String borrowerName) {
        isCheckedOut = true;
        this.borrowerName = borrowerName;
    }

    public void checkIn() {
        isCheckedOut = false;
        borrowerName = null;
    }

    public abstract String getItemType();
    public abstract double calculateLateFee(int daysLate);
}

