package bigdata.userInterface.output; /**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import bigdata.analytics.AnalyticsService;
import bigdata.analytics.AnalyticsServiceImpl;
import bigdata.analytics.dto.CountryRateGroupDto;
import bigdata.analytics.rategroup.RateGroupType;
import bigdata.userInterface.connexion.SelectYearType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;

/**
 * An advanced bubble chart with a variety of actions and settable properties.
 *
 * @see javafx.scene.chart.BubbleChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.NumberAxis
 * @see javafx.scene.chart.ScatterChart
 * @see javafx.scene.chart.XYChart
 */

public class AdvancedBubbleChartSample extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart());
    }

    protected BubbleChart<Number, Number> createChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BubbleChart<Number,Number> bc = new BubbleChart<Number,Number>(xAxis,yAxis);

        BubblesList bubblesList = new BubblesList();

        AnalyticsService analyticsService = new AnalyticsServiceImpl();

        List<CountryRateGroupDto> listCountryRateGroupDto = analyticsService.getRateGroupByType(RateGroupType.valueOf(SelectYearType.selectType),SelectYearType.selectYear);

        for(CountryRateGroupDto countryRateGroupDto  : listCountryRateGroupDto){
            double year_N = countryRateGroupDto.getSelectedYear().getValue();
            //System.out.println(dataTaux.getYear2012().replace(',', '.'));
            double year_N_1 = countryRateGroupDto.getPreviousSelectedYear().getValue();
            double variation = year_N - year_N_1;
            double idCountry = countryRateGroupDto.getIdCountry();

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

        // setup chart
        bc.setTitle("Advanced BubbleChart");
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        // add starting data
        XYChart.Series<Number,Number> series1 = new XYChart.Series<Number,Number>();
        series1.setName("Data Series 1");
        series1.getData().addAll(bubblesList.getListNegative());
        
        XYChart.Series<Number,Number> series2 = new XYChart.Series<Number,Number>();
        series2.setName("Data Series 2");
        series2.getData().addAll(bubblesList.getListPositive());
        
        XYChart.Series<Number,Number> series3 = new XYChart.Series<Number,Number>();
        series3.setName("Data Series 3");
        series3.getData().addAll(bubblesList.getListNull());
        
        bc.getData().addAll(series1, series2,series3);
        return bc;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}