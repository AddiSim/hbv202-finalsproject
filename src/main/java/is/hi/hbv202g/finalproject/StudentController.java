package is.hi.hbv202g.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

public class StudentController {

    @FXML
    public
    ListView<Book> booksListView;
    @FXML
    private ListView<Lending> borrowedBooksListView;
    private LibrarySystem librarySystem;
    private Student loggedInStudent;
    private App main;

    public void setLibrarySystem(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        booksListView.getItems().setAll(librarySystem.getBooks());
    }

    public void setLoggedInStudent(Student student) {
        this.loggedInStudent = student;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    public void handleBorrowBookAction(ActionEvent event) {
        Book selectedBook = booksListView.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            showAlert("Selection Error", "You must select a book to borrow.");
            return;
        }
        try {
            librarySystem.borrowBook(loggedInStudent, selectedBook);

            booksListView.getItems().setAll(librarySystem.getBooks());
            borrowedBooksListView.getItems().setAll(librarySystem.getLendings());
            showAlert("Book borrowed: " + selectedBook + " by " + loggedInStudent + "\n", String.valueOf(selectedBook));
        } catch (Exception e) {
            showAlert("Error borrowing book", "Please try again.");
        }
    }


    @FXML
    private void handleReturnBookAction(ActionEvent event) {
        Lending selectedBook = borrowedBooksListView.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            showAlert("No Book Selected", "Please select a book to borrow.");
            return;
        }

        try {
            librarySystem.returnBook(loggedInStudent, selectedBook.getBook());
            showAlert("Book Returned!", "You have successfully returned the book" + selectedBook);
            booksListView.getItems().setAll(librarySystem.getBooks());
            borrowedBooksListView.getItems().setAll(librarySystem.getLendings());
        } catch (Exception e) {
            showAlert("Error Borrowing Book", e.getMessage());
        }
    }

    public void setMainApp(App main) {
        this.main = main;
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        main.showUserSelectionScreen();
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
