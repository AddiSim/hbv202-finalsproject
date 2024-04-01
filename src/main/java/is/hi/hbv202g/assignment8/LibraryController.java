package is.hi.hbv202g.assignment8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class LibraryController {

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private ListView<Book> booksListView;

    private LibrarySystem librarySystem;

    public LibraryController() {
        librarySystem = new LibrarySystem();
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleAddBookAction(ActionEvent event) {
        try {
            String title = titleField.getText();
            String authorName = authorField.getText();
            librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
            updateBooksListView();
            clearForm();
        } catch (EmptyAuthorListException e) {
            showAlert("Add Book Error", "The author list cannot be empty.");
        }
    }

    private void updateBooksListView() {
        booksListView.getItems().setAll(librarySystem.getBooks());
    }

    private void clearForm() {
        titleField.clear();
        authorField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
