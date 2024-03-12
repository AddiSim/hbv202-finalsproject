package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {

    private List<Book> books;
    private Map<String, User> users;
    private List<Lending> lendings;

    public LibrarySystem() {
        books = new ArrayList<>();
        users = new HashMap<>();
        lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        try {
            Author author = new Author(authorName);
            List<Author> authors = new ArrayList<>();
            authors.add(author);
            Book book = new Book(title, authors);
            books.add(book);
        } catch (EmptyAuthorListException e) {
            e.printStackTrace();
        }
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) {
        try {
            Book book = new Book(title, authors);
            books.add(book);
        } catch (EmptyAuthorListException e) {
            e.printStackTrace();
        }
    }

    public void addStudentUser(String name, boolean feePaid) {
        User student = new Student(name, feePaid);
        users.put(name, student);
    }

    public void addFacultyMemberUser(String name, String department) {
        User facultyMember = new FacultyMember(name, department);
        users.put(name, facultyMember);
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title '" + title + "' does not exist.");
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        User user = users.get(name);
        if (user == null) {
            throw new UserOrBookDoesNotExistException("User with name '" + name + "' does not exist.");
        }
        return user;
    }

    public void borrowBook(User user, Book book, LocalDate dueDate) {
        Lending lending = new Lending(book, user, dueDate);
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
