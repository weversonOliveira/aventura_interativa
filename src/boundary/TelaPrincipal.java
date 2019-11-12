package boundary;

import control.ControlTelas;
import javafx.application.Application;
import javafx.stage.Stage;

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
