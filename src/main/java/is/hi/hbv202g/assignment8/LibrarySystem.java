package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    public LibrarySystem() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) throws EmptyAuthorListException {
        Author author = new Author(authorName);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book(title, authors);
        books.add(book);
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        Book book = new Book(title, authors);
        books.add(book);
    }

    public void addStudentUser(String name, boolean feePaid) {
        User student = new Student(name, feePaid);
        users.add(student);
    }

    public void addFacultyMemberUser(String name, String department) {
        User facultyMember = new FacultyMember(name, department);
        users.add(facultyMember);
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title '" + title + "' does not exist.");
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User with name '" + name + "' does not exist.");
    }

    public void borrowBook(User user, Book book) {
        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    public void extendLending(User user, Book book, LocalDate newDueDate) {
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                lending.setDueDate(newDueDate);
                break;
            }
        }
    }

    public void returnBook(User user, Book book) {
        lendings.removeIf(lending -> lending.getBook().equals(book) && lending.getUser().equals(user));
    }
}
