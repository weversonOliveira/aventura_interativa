package boundary;

import control.ControlLogin;
import entity.Jogador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TelaLogin implements Telas, EventHandler<ActionEvent> {

	public TelaLogin(Executor e) {
		this.setExecutor(e);
	}

	private ControlLogin controLogin = new ControlLogin ();
	private Button btnLogin = new Button("Login");
	private TextField txtNome = new TextField();
	private PasswordField txtSenha = new PasswordField();

	private Button btnCadastro = new Button("Cadastrar");
	private TextField txtCadNome = new TextField();
	private PasswordField txtCadSenha = new PasswordField();
	private PasswordField txtCadSenhaConf = new PasswordField();
	private Executor executor;

	@Override
	public Scene gerarTela() {

		BorderPane paneB0 = new BorderPane();
		GridPane paneGEsq = new GridPane();
		GridPane paneGDir = new GridPane();

		btnLogin.addEventHandler(ActionEvent.ANY, this);
		btnCadastro.addEventHandler(ActionEvent.ANY, this);

		paneGDir.setVgap(15);
		paneGEsq.setVgap(15);

		paneGDir.setHgap(10);
		paneGEsq.setHgap(10);

		//paneGEsq.add (new Label("Nome"));

		paneGEsq.add(new Label("Nome"), 1, 0);
		paneGEsq.add(txtNome, 2, 0);
		paneGEsq.add(new Label("Senha"), 1, 1);
		paneGEsq.add(txtSenha, 2, 1);
		paneGEsq.add(btnLogin, 2, 2);

		paneGDir.add(new Label("Novo Nome"), 1, 0);
		paneGDir.add(txtCadNome, 2, 0);
		paneGDir.add(new Label("Senha"), 1, 1);
		paneGDir.add(txtCadSenha, 2, 1);
		paneGDir.add(new Label("Confirme sua Senha"), 1, 2);
		paneGDir.add(txtCadSenhaConf, 2, 2);
		paneGDir.add(btnCadastro, 2, 3);

		Label lblLogo = new Label("Aventura Interativa");
		lblLogo.setStyle("-fx-font-family: 'DejaVu Sans Mono'; -fx-font-size: 50;");
		paneB0.setAlignment(lblLogo, Pos.CENTER);
		paneB0.setTop(lblLogo);
		paneB0.setLeft(paneGEsq);
		paneB0.setCenter(paneGDir);
		paneB0.setMargin(paneGDir, new Insets(0, 0, 0, 15));

		return new Scene(paneB0, 600, 400);

	}

	@Override
	public void handle(ActionEvent event) {

		Alert alert = new Alert(Alert.AlertType.WARNING);

		if (event.getTarget() == btnLogin) {

			if(controLogin.login(txtNome.getText(),txtSenha.getText ())) {

				txtNome.clear();
				txtSenha.clear();
				executor.executar ("save");
			}else {
				alert.setAlertType(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Verifique seus dados");
				alert.setContentText("Senha ou Nome não correspondem");
				alert.show();
				txtNome.clear();
				txtSenha.clear();
			}

		} else if (event.getTarget() == btnCadastro) {

			if (controLogin.verificaNome (boundaryForEntityCad ())) {

				if (controLogin.verificaIgualdade (txtCadSenha.getText (), txtCadSenhaConf.getText ())) {

					controLogin.cadastrar (boundaryForEntityCad ());

					alert.setAlertType (Alert.AlertType.INFORMATION);
					alert.setHeaderText ("Boa Sorte");
					alert.setContentText ("Cadastro Efetuado com Sucesso");
					alert.show ();
					txtCadNome.clear ();
					txtCadSenha.clear ();
					txtCadSenhaConf.clear ();
				} else {

					alert.setAlertType (Alert.AlertType.WARNING);
					alert.setHeaderText ("As Senhas digitadas não correspondem");
					alert.setContentText ("Por favor digite senhas iguais!!!");
					alert.showAndWait ();
					txtCadSenha.clear ();
					txtCadSenhaConf.clear ();
				}
			}else {

				alert.setAlertType (Alert.AlertType.WARNING);
				alert.setHeaderText ("Nome já existe !!!");
				alert.setContentText ("Por favor escolha outro nome");
				alert.showAndWait ();
				txtCadNome.clear ();
			}
		}
	}

	public Jogador boundaryForEntityCad() {

		Jogador jogador = new Jogador();

		jogador.setNome(txtCadNome.getText());
		jogador.setSenha(txtCadSenha.getText());
		System.out.println("boundaryForEntityCad nome - " + jogador.getNome());

		return jogador;
	}

	public Jogador boundaryForEntityLogin() {

		Jogador jogador = new Jogador();

		jogador.setNome(txtNome.getText());
		jogador.setSenha(txtSenha.getText());

		return jogador;
	}

//	public void entityForBoundary(Jogador jogador) {
//
//		Alert alertSenhas = new Alert(Alert.AlertType.INFORMATION);
//
//		if (jogador != null) {
//			txtNome.setText(jogador.getNome());
//			txtSenha.setText(jogador.getSenha());
//			alertSenhas.setContentText("Login Efetuado com Sucesso");
//			alertSenhas.showAndWait();
//		} else {
//			alertSenhas.setContentText("Insira Nome e Senha");
//			alertSenhas.showAndWait();
//
//		}
//	}

	@Override
	public void setExecutor(Executor e) {
		this.executor = e;
	}

	@Override
	public boundary.Executor getExecutor() {
		return this.executor;
	}
}