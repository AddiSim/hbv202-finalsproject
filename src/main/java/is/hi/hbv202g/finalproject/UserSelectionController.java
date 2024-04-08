package is.hi.hbv202g.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UserSelectionController {

    @FXML
    private TextField userNameField;

    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    private Button loginButton;

    private LibrarySystem librarySystem;
    private App main;

    public void setLibrarySystem(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    public void setMainApp(App main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        userTypeComboBox.getItems().addAll("Student", "Faculty Member");
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        String name = userNameField.getText().trim();
        String userType = userTypeComboBox.getValue();

        if (name.isEmpty() || userType == null) {
            showAlert("Validation Error", "Both name and user type are required.");
            return;
        }
        if ("Student".equals(userType)) {
            Student tempStudent = new Student(name, true);
            main.showUserScreen(tempStudent);
        } else if ("Faculty Member".equals(userType)) {
            FacultyMember tempFaculty = new FacultyMember(name, "Department");
            main.showUserScreen(tempFaculty);
        } else {
            showAlert("Error", "Invalid user type selected.");
        }
    }

}
