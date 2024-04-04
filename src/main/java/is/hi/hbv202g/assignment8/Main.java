package is.hi.hbv202g.assignment8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private LibrarySystem librarySystem = new LibrarySystem();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showUserSelectionScreen();
    }

    public void showUserSelectionScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assignment8/UserSelectionScreen.fxml"));
            Scene scene = new Scene(loader.load());
            UserSelectionController controller = loader.getController();
            controller.setLibrarySystem(librarySystem);
            controller.setMainApp(this);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUserScreen(User user) {
        try {
            String fxmlFile = user instanceof Student ? "/assignment8/StudentScreen.fxml" : "/assignment8/FacultyScreen.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);

            if (user instanceof Student) {
                StudentController studentController = loader.getController();
                studentController.setLibrarySystem(librarySystem);
                studentController.setLoggedInStudent((Student) user);
                studentController.setMainApp(this);
            } else if (user instanceof FacultyMember) {
                FacultyController facultyController = loader.getController();
                facultyController.setLibrarySystem(librarySystem);
                facultyController.setFacultyMember((FacultyMember) user);
                facultyController.setMainApp(this);
            }

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showStudentScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assignment8/StudentScreen.fxml"));
            Scene scene = new Scene(loader.load());
            StudentController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFacultyScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assignment8/FacultyScreen.fxml"));
            Scene scene = new Scene(loader.load());
            StudentController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
