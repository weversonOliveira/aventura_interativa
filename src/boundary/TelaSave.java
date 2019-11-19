package boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TelaSave implements Telas, EventHandler<ActionEvent> {

	public TelaSave(Executor e) {
		this.setExecutor(e);
	}
	private BorderPane paneB0 = new BorderPane();
	private GridPane paneG0 = new GridPane();
	private Scene telaSave = new Scene(paneB0, 600, 400);

	private Button btnSlot1 = new Button("Slot 1");
	private Button btnSlot2 = new Button("Slot 2");
	private Button btnSlot3 = new Button("Slot 3");
	private Button btnSair = new Button ("Sair");
	private Executor executor;

	@Override
	public Scene gerarTela() {

		btnSlot1.setPrefSize(100, 50);
		btnSlot2.setPrefSize(100, 50);
		btnSlot3.setPrefSize(100, 50);

		btnSlot1.addEventHandler(ActionEvent.ANY, this);
		btnSlot2.addEventHandler(ActionEvent.ANY, this);
		btnSlot3.addEventHandler(ActionEvent.ANY, this);
		btnSair.addEventHandler (ActionEvent.ANY,this);

		paneG0.add(btnSlot1, 1, 0);
		paneG0.add(btnSlot2, 1, 1);
		paneG0.add(btnSlot3, 1, 2);

		Label lblLogo = new Label("Aventura Interativa");
		lblLogo.setStyle("-fx-font-family: sample; -fx-font-size: 50;");
		paneB0.setAlignment(lblLogo, Pos.CENTER);

		paneB0.setTop(lblLogo);
		paneB0.setCenter(paneG0);
		paneB0.setBottom (btnSair);
		return telaSave;
	}

	@Override
	public void handle(ActionEvent event) {
		executor.executar("login");
	}
	@Override
	public void setExecutor(Executor e) {
		this.executor = e;
	}

	@Override
	public boundary.Executor getExecutor() {
		return this.executor;
	}


}