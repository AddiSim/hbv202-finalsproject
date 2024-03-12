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

    public void returnBook(User user, Book book) throws Exception {
        boolean found = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book)) {
                if (lending.getUser().equals(user)) {
                    lendings.remove(lending);
                    found = true;
                    break;
                } else {
                    throw new Exception("Book was borrowed by a different user.");
                }
            }
        }
        if (!found) {
            throw new Exception("Book was not borrowed.");
        }
    }
}
