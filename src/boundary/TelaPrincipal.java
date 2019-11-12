package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

<<<<<<< HEAD
public class TelaPrincipal extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle ("Aventura Interativa");

        TelaLogin telaLogin = new TelaLogin();
        TelaSave telaSave = new TelaSave ();
        //TelaGame telaGame = new TelaGame ();

        stage.setScene(telaLogin.gerarTela ());
        stage.show();
    }

    public static void main(String[] args){

        launch(args);
    }
}
=======
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
>>>>>>> 7d614cc7a68fd242c92eb0b502cd741644dd7d45
