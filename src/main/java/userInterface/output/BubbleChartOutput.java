package userInterface.output;

import data.DataTaux;
import dataAccess.DaoData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by oliver on 17/02/15.
 */
public class BubbleChartOutput extends Application {

    public BubbleChartOutput(){

    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Taux année N", 0d, 150d, 20d);
        NumberAxis yAxis = new NumberAxis("Country", 0d, 250d, 20d);

        //BubbleChart.Series devNull = new BubbleChart.Series("null", FXCollections.observableArrayList(new XYChart.Data(0d, 0d, 0d)));

        BubblesList bubblesList = new BubblesList();

        List<DataTaux> listDataTaux = DaoData.getInstance().readALL();

        for(DataTaux dataTaux  : listDataTaux){
            double year_N = Double.parseDouble(dataTaux.getYear2012().replace(',','.'));
            System.out.println(dataTaux.getYear2012().replace(',', '.'));
            double year_N_1 = Double.parseDouble(dataTaux.getYear2011().replace(',', '.'));
            double variation = year_N - year_N_1;
            double idCountry = dataTaux.getId();
            if (variation<0)
                variation = variation -(2*variation);
            Bubble bubble = new Bubble(
                    new XYChart.Data(
                            year_N,
                            idCountry*6,
                            variation*1.5),
                    year_N_1);
            bubblesList.fetch(bubble);
        }

        BubbleChart.Series negative = new BubbleChart.Series("Negative", bubblesList.getListNegative());
        BubbleChart.Series positive = new BubbleChart.Series("Positive", bubblesList.getListPositive());
        BubbleChart.Series devNull = new BubbleChart.Series("Nulle", bubblesList.getListNull());

        ObservableList<BubbleChart.Series> bubbleChartData = FXCollections.observableArrayList(negative,devNull,positive);

        BubbleChart chart = new BubbleChart(xAxis, yAxis, bubbleChartData);
        root.getChildren().add(chart);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
