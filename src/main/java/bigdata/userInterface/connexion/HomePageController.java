package bigdata.userInterface.connexion;

import bigdata.importation.ImportationService;
import bigdata.importation.ImportationServiceImpl;
import bigdata.userInterface.output.BubbleChartOutput;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    private boolean selectYear = false;
    private boolean selectType = false;
    
    @FXML
    ComboBox comboBoxSelectYear;
    @FXML
    ComboBox comboBoxRateGroup;
    
    private ImportationService importationService = new ImportationServiceImpl();
    /**
     * Initializes the controller class.
     */

    @FXML
    private Desktop desktop = Desktop.getDesktop();

    @FXML
    private void handleButtonActionOpenFile(ActionEvent event) throws IOException {


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser();

        // Filtrer le type de fichier à sélectionner
        /*
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);
        */
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel files 97-2003 (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx")
        );

        fileChooser.setTitle("DATA VIZOR : Ouvrir le fichier source");

        // File defaultDirectory = new File("C:/Users/Herve/Documents/NetBeansProjects/SQLiteAppFx");
        File defaultDirectory = new File("C:/");
        fileChooser.setInitialDirectory(defaultDirectory);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            importationService.importFileData(file);
            initSelectYear(file);
            selectRateGroup(file);
        }

    }

    private void initSelectYear(File file) throws IOException {
        ImportationService importationService = new ImportationServiceImpl();

        this.comboBoxSelectYear.setDisable(false);
        this.comboBoxSelectYear.getItems().addAll(importationService.getYearFileData(file));
        this.comboBoxSelectYear.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        SelectYearType.selectYear = comboBoxSelectYear.getSelectionModel().getSelectedItem().toString();
                        selectYear = true;
                    }
                }
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void chartOpenButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        if (selectType && selectYear){
            try {
                new BubbleChartOutput().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Dialogs.create()
                    .owner(stage)
                    .title("NO DATA SELECTED!")
                    .masthead("NO DATA SELECTED!")
                    .message("Please select type and year before and a file!")
                    .showError();
        }
    }

    public void selectRateGroup(File file) {
        ImportationService importationService = new ImportationServiceImpl();

        this.comboBoxRateGroup.setDisable(false);
        this.comboBoxRateGroup.getItems().addAll(importationService.getRateGroupList(file));
        this.comboBoxRateGroup.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        SelectYearType.selectType = comboBoxRateGroup.getSelectionModel().getSelectedItem().toString();
                        selectType = true;
                    }
                }
        );
    }
}
