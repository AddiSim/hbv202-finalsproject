package is.hi.hbv202g.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FacultyController {
    @FXML
    public
    TextField titleField;
    @FXML
    public
    TextField authorField;
    @FXML
    private Button addButton;

    private LibrarySystem librarySystem;
    private FacultyMember facultyMember;
    private App main;

    public void setLibrarySystem(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    public void setFacultyMember(FacultyMember facultyMember) {
        this.facultyMember = facultyMember;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    public void handleAddBookAction(ActionEvent event) {
        try {
            String title = titleField.getText();
            String authorName = authorField.getText();
            librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
            clearForm();
        } catch (EmptyAuthorListException e) {
            showAlert("Add Book Error", "The author list cannot be empty.");
        }
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

    public void setMainApp(App main) {
        this.main = main;
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        main.showUserSelectionScreen();
    }
}
