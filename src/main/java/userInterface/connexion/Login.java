package userInterface.connexion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml")); // getResource("../../../resources/Login.fxml")

        Scene scene = new Scene(root);

        String css = "/Style.css";
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();

    }
}