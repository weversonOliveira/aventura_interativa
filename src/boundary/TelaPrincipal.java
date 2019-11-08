package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaPrincipal extends Application implements Executor {
	TelaLogin telaLogin = new TelaLogin(this);
	TelaSave telaSave = new TelaSave(this);
	TelaGame telaGame = new TelaGame(this);
	Stage stage;

	@Override
	public void executar(String cmd) {
		switch (cmd) {
		case "save":
			stage.setScene(telaSave.gerarTela());
			break;
		case "game":
			stage.setScene(telaGame.gerarTela());
			break;
		case "login":
			stage.setScene(telaLogin.gerarTela());
			break;
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setTitle("Aventura Interativa");
		
		executar("login");
		stage.show();
	}


	public static void main(String[] args) {

		launch(args);
	}
}