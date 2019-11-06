package boundary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TelaSave implements Telas {

    @Override
    public Scene gerarTela() {

        BorderPane paneB0 = new BorderPane ();
        GridPane paneG0 = new GridPane ();

        Button btnSlot1 = new Button ("Slot 3");
        Button btnSlot2 = new Button ("Slot 3");
        Button btnSlot3 = new Button ("Slot 3");

        btnSlot1.setPrefSize (100,50);
        btnSlot2.setPrefSize (100,50);
        btnSlot3.setPrefSize (100,50);


        paneG0.add (btnSlot1,1,0);
        paneG0.add (btnSlot2,1,1);
        paneG0.add (btnSlot3,1,2);

        paneB0.setCenter (paneG0);

        Scene telaSave = new Scene (paneB0,1000,800);
        return telaSave;
    }

}
