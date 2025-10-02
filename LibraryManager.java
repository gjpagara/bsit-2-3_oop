import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Borrowable> items;

    public LibraryManager() {
        items = new ArrayList<>();
    }

    public void addItem(Borrowable item) {
        items.add(item);
    }

    public void displayAllItemsFormatted() {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem li) {
                System.out.println(li.getItemType() + ": " + li.title + " (" + item.getBorrowingStatus() + ")");
            }
        }
    }

    public void displayAvailableItemsFormatted() {
        for (Borrowable item : items) {
            if (item.isAvailable()) {
                if (item instanceof LibraryItem li) {
                    System.out.println(li.getItemType() + ": " + li.title + " (" + item.getBorrowingStatus() + ")");
                }
            }
        }
    }

    public void borrowItem(String itemId, User user) {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem li && li.itemId.equals(itemId)) {
                if (item.isAvailable()) {
                    if (user.getBorrowedItemsCount() < user.getMaxBorrowLimit()) {
                        item.borrowItem(user.getName());
                        user.addBorrowedItem(li);
                        System.out.println(user.getClass().getSimpleName() + " " + user.getName() + " borrowed: " + li.title);
                    } else {
                        System.out.println("Error: " + user.getName() + " has reached their maximum borrowing limit of " + user.getMaxBorrowLimit() + " items.");
                    }
                } else {
                    System.out.println("Error: Item '" + li.title + "' is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Error: Item with ID " + itemId + " not found.");
    }

    public void returnItem(String itemId, User user) {
        for (Borrowable item : items) {
            if (item instanceof LibraryItem li && li.itemId.equals(itemId)) {
                if (!item.isAvailable() && user.getName().equals(li.borrowerName)) {
                    item.returnItem();
                    user.removeBorrowedItem(li);
                    System.out.println(user.getName() + " returned: " + li.title);
                } else if (item.isAvailable()) {
                    System.out.println("Error: Item '" + li.title + "' was not checked out.");
                } else {
                    System.out.println("Error: Item '" + li.title + "' was borrowed by someone else.");
                }
                return;
            }
        }
        System.out.println("Error: Item with ID " + itemId + " not found.");
    }


    public double calculateTotalLateFees(int daysLate) {
        double total = 0.0;
        for (Borrowable item : items) {
            if (item instanceof LibraryItem li && !item.isAvailable()) {
                total += li.calculateLateFee(daysLate);
            }
        }
        return total;
    }
}
