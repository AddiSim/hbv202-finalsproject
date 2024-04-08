package is.hi.hbv202g.finalproject;

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
        String bookDetails = book != null ? book.toString() : "No Book";

        String userDetails = user != null ? user.toString() : "No User";

        String dueDateString = dueDate != null ? dueDate.toString() : "No Due Date";

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
