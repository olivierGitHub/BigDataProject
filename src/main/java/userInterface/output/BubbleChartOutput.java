package userInterface.output;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Created by oliver on 17/02/15.
 */
public class BubbleChartOutput extends Application {

    public BubbleChartOutput(){

    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("X", 0d, 150d, 20d);
        NumberAxis yAxis = new NumberAxis("Y", 0d, 150d, 20d);

        BubbleChart.Series devNull = new BubbleChart.Series("null", FXCollections.observableArrayList(new XYChart.Data(0d, 0d, 0d)));

        Bubble france = new Bubble(new XYChart.Data(30d, 40d, 10d), 10d);
        Bubble canada = new Bubble(new XYChart.Data(20d, 20d, 20d), 30d);
        Bubble usa = new Bubble(new XYChart.Data(100d, 80d, 50d), 10d);
        Bubble japan = new Bubble(new XYChart.Data(70d, 50d, 30d), 10d);
        Bubble spain = new Bubble(new XYChart.Data(10d, 10d, 10d), 20d);

        BubblesList bubblesList = new BubblesList();

        bubblesList.fetch(france);
        bubblesList.fetch(canada);
        bubblesList.fetch(usa);
        bubblesList.fetch(japan);
        bubblesList.fetch(spain);

        BubbleChart.Series negative = new BubbleChart.Series("Negative", bubblesList.getListNegative());
        BubbleChart.Series positive = new BubbleChart.Series("Positive", bubblesList.getListPositive());

        ObservableList<BubbleChart.Series> bubbleChartData = FXCollections.observableArrayList(
                negative,devNull,positive);

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
