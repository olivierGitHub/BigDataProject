package bigdata.userInterface.output;

import bigdata.analytics.AnalyticsService;
import bigdata.analytics.AnalyticsServiceImpl;
import bigdata.analytics.dto.CountryRateGroupDto;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.userInterface.connexion.SelectYearType;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class BubbleChartOutput extends Application {

    public BubbleChartOutput() {

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis yAxis = new NumberAxis("Taux année N", 40d, 150d, 20d);
        NumberAxis xAxis = new NumberAxis("Country", 0d, 220d, 20d);
        final Text text = new Text(0,0, "");
        text.setStyle("-fx-font-size: 22;");
        text.setTextOrigin(VPos.TOP);
        text.setTextAlignment(TextAlignment.CENTER);

        BubblesList bubblesList = new BubblesList();

        AnalyticsService analyticsService = new AnalyticsServiceImpl();

        List<CountryRateGroupDto> listCountryRateGroupDto = analyticsService.getRateGroupByType(RateGroupType.valueOf(SelectYearType.selectType),SelectYearType.selectYear);

        for(CountryRateGroupDto countryRateGroupDto  : listCountryRateGroupDto){
            double year_N = countryRateGroupDto.getSelectedYear().getValue();
            //System.out.println(dataTaux.getYear2012().replace(',', '.'));
            double year_N_1 = countryRateGroupDto.getPreviousSelectedYear().getValue();
            double variation = year_N - year_N_1;
            double idCountry = countryRateGroupDto.getIdCountry();
            System.out.println("vue: idCountry = " + idCountry);
            System.out.println("vue: variation = " + variation);
            System.out.println("vue: year_N_1 = " + year_N_1);
            System.out.println("vue: year_N = " + year_N);

            variation = Math.abs(variation);
            Bubble bubble = new Bubble(
                    new XYChart.Data(
                            idCountry*6,
                            year_N,
                            variation*1.5),
                    year_N_1,year_N);
            //bubble.setHoveredProperty(text,countryRateGroupDto.getCountryName());
            bubblesList.fetch(bubble);
        }

        BubbleChart.Series negative = new BubbleChart.Series("Negative", bubblesList.getListNegative());
        BubbleChart.Series positive = new BubbleChart.Series("Positive", bubblesList.getListPositive());
        BubbleChart.Series devNull = new BubbleChart.Series("Nulle", bubblesList.getListNull());

        ObservableList<BubbleChart.Series> bubbleChartData = FXCollections.observableArrayList(negative, devNull, positive);

        BubbleChart chart = new BubbleChart(xAxis, yAxis/*, bubbleChartData*/);

        root.getChildren().add(chart);
        chart.getData().addAll(negative,devNull,positive);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
