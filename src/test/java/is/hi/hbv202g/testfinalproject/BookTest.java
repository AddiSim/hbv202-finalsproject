package is.hi.hbv202g.testfinalproject;

import is.hi.hbv202g.finalproject.Author;
import is.hi.hbv202g.finalproject.Book;
import is.hi.hbv202g.finalproject.EmptyAuthorListException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class BookTest {

    @Test
    void testSingleAuthorConstructor() {
        Book book = new Book("Test Title", "Test Author");
        Assertions.assertEquals("Test Title", book.getTitle());
        Assertions.assertEquals(1, book.getAuthors().size());
        Assertions.assertEquals("Test Author", book.getAuthors().get(0).getName());
    }

    @Test
    void testListAuthorConstructor() throws EmptyAuthorListException {
        Author author = new Author("Test Author");
        Book book = new Book("Test Title", Collections.singletonList(author));
        Assertions.assertEquals("Test Title", book.getTitle());
        Assertions.assertEquals(1, book.getAuthors().size());
        Assertions.assertEquals("Test Author", book.getAuthors().get(0).getName());
    }

    @Test
    void testAddAuthor() {
        Author initialAuthor = new Author("Initial Author");
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(initialAuthor);

        Book book = null;
        try {
            book = new Book("Test Title", authors);
        } catch (EmptyAuthorListException e) {
            e.printStackTrace();
        }
        assert book != null;
        book.addAuthor(new Author("New Author"));

        Assertions.assertEquals(2, book.getAuthors().size());
        Assertions.assertEquals("New Author", book.getAuthors().get(1).getName());
    }

    @Test
    void testConstructorWithEmptyAuthorList() {
        Assertions.assertThrows(EmptyAuthorListException.class, () -> {
            new Book("Test Title", new ArrayList<>());
        });
    }
}
