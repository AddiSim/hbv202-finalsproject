package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {
    private LocalDate dueDate;
    private User user;
    private Book book;

    public Lending(Book book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(30);
    }

    @Override
    public String toString() {
        // Use the Book's toString method to get book details
        String bookDetails = book != null ? book.toString() : "No Book";

        // Use the User's toString method to get user details
        String userDetails = user != null ? user.toString() : "No User";

        // Format the due date
        String dueDateString = dueDate != null ? dueDate.toString() : "No Due Date";

        // Construct the full string
        return "Lending: {" + "Book: " + bookDetails + ", User: " + userDetails + ", Due Date: " + dueDateString + "}";
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
