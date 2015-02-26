package bigdata.userInterface.output;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

public class Bubble {

    private XYChart.Data bubble;
    private double rateN_1;
    private double rateN;
    private String variation;

    public Bubble(XYChart.Data bubble, double rateN_1, double rateN) {
        this.bubble = bubble;
        this.rateN_1 = rateN_1;
        this.rateN = rateN;
    }

    public String getVariation() {
        if ((rateN - rateN_1) > 0)
            variation = "positive";
        else if ((rateN - rateN_1) < 0)
            variation = "negative";
        else
            variation = "nulle";
        return variation;
    }

    public XYChart.Data getBubble() {
        return bubble;
    }

    public void setHoveredProperty(final Text text, final String countryName) {
        bubble.getNode().hoverProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (bubble.getNode().isHover()) {
                    text.setText(countryName);
                } else {
                    text.setText("");
                }
            }
        });
    }

}
