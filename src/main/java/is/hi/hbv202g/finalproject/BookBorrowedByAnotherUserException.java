package is.hi.hbv202g.finalproject;

public class BookBorrowedByAnotherUserException extends Exception {
    public BookBorrowedByAnotherUserException(String message) {
        super(message);
    }
}
