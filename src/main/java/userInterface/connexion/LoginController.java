package userInterface.connexion;

import userInterface.connexion.entity.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Herve on 18/02/2015.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label message;


    private List<userInterface.connexion.entity.Login> listLogin = new ArrayList<>();

    private LoginQuery query = new LoginQuery();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        query.initUser();
        listLogin = query.listLogin();
    }


    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        for(userInterface.connexion.entity.Login l : listLogin) {
            if(username.getText().equals(l.getUsername())){
                if(password.getText().equals(l.getPassword())){
                    (((Node)event.getSource()).getScene()).getWindow().hide();
                    Parent parent = FXMLLoader.load(getClass().getResource("/HomePage.fxml"));
                    Scene scene = new Scene(parent);

                    String css = "/Style.css";

                    scene.getStylesheets().add(css);
                    Stage stage = new Stage();
                    stage.setTitle("Welcome to Data Vizor Application");
                    stage.setScene(scene);
                    stage.show();
                } else {
                    message.setText("Le mot de passe est invalide !");
                }
            } else {
                message.setText("Le username est invalide !");
            }
        }
    }


}
