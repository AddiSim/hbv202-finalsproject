package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;

    public Book(String title, String authorName) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(new Author(authorName));
    }

    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("A book must have at least one author.");
        }
        this.title = title;
        this.authors = authors;
    }

    @Override
    public String toString() {
        String authorName = authors != null && !authors.isEmpty() ? authors.get(0).getName() : "No Author";
        return title + " by " + authorName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("A book must have at least one author.");
        }
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new ArrayList<>();
        }
        this.authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
