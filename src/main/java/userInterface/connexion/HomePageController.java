package userInterface.connexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    MenuButton menuButtonSelectYear;

   /*
    @FXML
    ComboBox comboBoxSelectYear; */
    /**
     * Initializes the controller class.
     */

    @FXML
    private Desktop desktop = Desktop.getDesktop();

    @FXML
    private void handleButtonActionOpenFile(ActionEvent event) throws IOException {

        System.out.println("You want to open a file !");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser();

        // Filtrer le type de fichier à sélectionner
        /*
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);
        */
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx"),
                new FileChooser.ExtensionFilter("Excel files 97-2003 (*.xls)", "*.xls")
        );

        fileChooser.setTitle("DATA VIZOR : Ouvrir le fichier source");

        // File defaultDirectory = new File("C:/Users/Herve/Documents/NetBeansProjects/SQLiteAppFx");
        File defaultDirectory = new File("C:/");
        fileChooser.setInitialDirectory(defaultDirectory);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
        }

    }


    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {

        }
    }


    @FXML
    private void menuSelectYear(ActionEvent event) throws IOException {

        MenuItem menu = (MenuItem) event.getSource();

        menuButtonSelectYear.setText(menu.getText());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


}
