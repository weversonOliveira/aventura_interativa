package control;

import Dao.JogadorDB;
import entity.Jogador;

public class ControlLogin {

	private JogadorDB jogadorDB = new JogadorDB ();

	public boolean login(String nome, String senha) {

		Jogador jogador;
		jogador=jogadorDB.consultarJogador (nome, senha);

		boolean existe = false;

		if (nome.equals (jogador.getNome ()) && (senha.equals (jogador.getSenha ()))) {
			existe = true;
		}

		return existe;
	}

	public void cadastrar (Jogador jogador){

		jogadorDB.cadastrarJogador (jogador);
		System.out.println ("Nome: " + jogador.getNome ());
		System.out.println ("Senha: " + jogador.getSenha ());


	}

	public boolean verificaNome(String nome){

		boolean existe = true;

		if (!jogadorDB.consultarNome (nome).equals (nome)){
			existe = false;
		}

		return existe;
	}


	public boolean verificaIgualdade (String primeira, String segunda){
		boolean resposta=false;
		if (primeira.equals (segunda)) {
			resposta=true;
		}
		return resposta;
	}
}
