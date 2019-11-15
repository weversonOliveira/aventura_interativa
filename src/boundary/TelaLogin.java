package boundary;

import control.ControlTelaLogin;
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

	ControlTelaLogin controlTelaLogin = new ControlTelaLogin();
	Button btnLogin = new Button("Login");
	TextField txtNome = new TextField();
	PasswordField txtSenha = new PasswordField();

	Button btnCadastro = new Button("Cadastrar");
	TextField txtCadNome = new TextField();
	PasswordField txtCadSenha = new PasswordField();
	PasswordField txtCadSenhaConf = new PasswordField();
	private Executor executor;

	@Override
	public Scene gerarTela() {

		BorderPane paneB0 = new BorderPane();
		GridPane paneGEsq = new GridPane();
		GridPane paneGDir = new GridPane();

		btnLogin.addEventHandler(ActionEvent.ANY, this);
		btnCadastro.addEventHandler(ActionEvent.ANY, this);

		Label lblnome = new Label("Nome");
		Label lblsenha = new Label("Senha");

		// Cadastro novo
		Label lblCadNome = new Label("Novo Nome");
		Label lblCadSenha = new Label("Senha");
		Label lblCadSenhaConf = new Label("Confirme sua Senha");

		paneGDir.setVgap(15);
		paneGEsq.setVgap(15);

		paneGDir.setHgap(10);
		paneGEsq.setHgap(10);

		paneGEsq.add(lblnome, 1, 0);
		paneGEsq.add(txtNome, 2, 0);
		paneGEsq.add(lblsenha, 1, 1);
		paneGEsq.add(txtSenha, 2, 1);
		paneGEsq.add(btnLogin, 2, 2);

		paneGDir.add(lblCadNome, 1, 0);
		paneGDir.add(txtCadNome, 2, 0);
		paneGDir.add(lblCadSenha, 1, 1);
		paneGDir.add(txtCadSenha, 2, 1);
		paneGDir.add(lblCadSenhaConf, 1, 2);
		paneGDir.add(txtCadSenhaConf, 2, 2);
		paneGDir.add(btnCadastro, 2, 3);

		Label lblLogo = new Label("Aventura Interativa");
		lblLogo.setStyle("-fx-font-family: sample; -fx-font-size: 50;");
		paneB0.setAlignment(lblLogo, Pos.CENTER);
		paneB0.setTop(lblLogo);
		paneB0.setLeft(paneGEsq);
		paneB0.setCenter(paneGDir);
		paneB0.setMargin(paneGDir, new Insets(0, 0, 0, 15));

		Scene telaLogin = new Scene(paneB0, 600, 400);

		return telaLogin;

	}

	@Override
	public void handle(ActionEvent event) {

		Alert alertSenhas = new Alert(Alert.AlertType.WARNING);

		if (event.getTarget() == btnLogin) {

			boolean existe = false;
			
			if(controlTelaLogin.login(boundaryForEntityLogin())) {
				executor.executar("save");
			}

		} else if (event.getTarget() == btnCadastro) {

			if (ControlTelaLogin.verificaIgualdade(txtCadSenha.getText(), txtCadSenhaConf.getText())) {

				controlTelaLogin.cadastrar(boundaryForEntityCad());

				System.out.println("cadastrou");

				alertSenhas.setAlertType(Alert.AlertType.INFORMATION);
				alertSenhas.setHeaderText("Boa Sorte");
				alertSenhas.setContentText("Cadastro Efetuado com Sucesso");
				alertSenhas.show();
				txtCadNome.clear();
				txtCadSenha.clear();
				txtCadSenhaConf.clear();

			} else {

				System.out.println("n?o cadastrou");
				alertSenhas.setAlertType(Alert.AlertType.WARNING);
				alertSenhas.setHeaderText("As Senhas digitadas não correspondem");
				alertSenhas.setContentText("Por favor digite senhas iguais!!!");
				alertSenhas.showAndWait();
				txtCadSenha.clear();
				txtCadSenhaConf.clear();
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
		System.out.println("boundaryForEntityLogin nome - " + jogador.getNome());

		return jogador;
	}

	public void entityForBoundary(Jogador jogador) {

		Alert alertSenhas = new Alert(Alert.AlertType.INFORMATION);

		if (jogador != null) {
			txtNome.setText(jogador.getNome());
			txtSenha.setText(jogador.getSenha());
			alertSenhas.setContentText("Login Efetuado com Sucesso");
			alertSenhas.showAndWait();
		} else {
			alertSenhas.setContentText("Insira Nome e Senha");
			alertSenhas.showAndWait();

		}
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