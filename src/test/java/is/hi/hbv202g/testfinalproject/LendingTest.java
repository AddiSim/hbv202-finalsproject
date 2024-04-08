package is.hi.hbv202g.testfinalproject;

import is.hi.hbv202g.finalproject.Book;
import is.hi.hbv202g.finalproject.EmptyAuthorListException;
import is.hi.hbv202g.finalproject.Lending;
import is.hi.hbv202g.finalproject.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LendingTest {

    @Test
    void testLendingToString() throws EmptyAuthorListException {
        Book book = new Book("Book Title", "Author Name");
        Student student = new Student("Student Name", true);
        Lending lending = new Lending(book, student);

        String expected = "Lending: {Book: Book Title by Author Name, User: Student Name, Due Date: " + lending.getDueDate().toString() + "}";
        Assertions.assertEquals(expected, lending.toString());
    }
}
