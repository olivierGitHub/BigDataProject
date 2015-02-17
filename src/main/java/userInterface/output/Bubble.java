package userInterface.output;

import javafx.scene.chart.XYChart;

/**
 * Created by oliver on 17/02/15.
 */
public class Bubble {

    private XYChart.Data bubble;
    private double rateN_1;
    private String variation;

    public Bubble (XYChart.Data bubble, double rateN_1){
        this.bubble = bubble;
        this.rateN_1 = rateN_1;
    }

    public String getVariation(){
        Double rateN = null;

        if (bubble.getXValue() instanceof Double) {
            rateN = (Double) bubble.getXValue();
            if ((rateN-rateN_1)>=0)
                variation = "positive";
            else
                variation = "negative";
        }
        return variation;
    }

    public XYChart.Data getBubble() {
        return bubble;
    }

}
