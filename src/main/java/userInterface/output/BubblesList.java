package userInterface.output;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by oliver on 17/02/15.
 */
public class BubblesList {

    ObservableList listNegative = FXCollections.observableArrayList();
    ObservableList listPositive = FXCollections.observableArrayList();
    ObservableList listNull = FXCollections.observableArrayList();

    public BubblesList(){
    }

    public void fetch(Bubble bubble){
        if (bubble.getVariation().equals("positive"))
            listPositive.add(bubble.getBubble());
        else if (bubble.getVariation().equals("negative"))
            listNegative.add(bubble.getBubble());
        else if (bubble.getVariation().equals("nulle"))
            listNull.add(bubble.getBubble());
    }

    public ObservableList getListNegative() {
        return listNegative;
    }
    public ObservableList getListPositive() {
        return listPositive;
    }
    public ObservableList getListNull() {
        return listNull;
    }

}
