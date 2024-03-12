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

    public Lending(Book book, User user, LocalDate dueDate) {
        this.book = book;
        this.user = user;
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(java.time.LocalDate dueDate) {
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
