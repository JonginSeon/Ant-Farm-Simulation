package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
    @FXML private Text actionTarget;

    @FXML protected void topRegionAction(ActionEvent event)
    {
        actionTarget.setText("You have pressed the top left square");
    }

}
