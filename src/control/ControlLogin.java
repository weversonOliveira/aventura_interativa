package control;

import Dao.JogadorDB;
import entity.Jogador;

public class ControlLogin {

	private JogadorDB jogadorDB = new JogadorDB ();

	public boolean login(String nome, String senha) {

		Jogador jogador1;
		jogador1 = jogadorDB.consultarJogador (nome, senha);

		boolean existe = false;

		if ((nome.equals (jogador1.getNome ())) && (senha.equals (jogador1.getSenha ()))) {
			existe = true;
		}

		return existe;
	}

	public void cadastrar (Jogador jogador){

		jogadorDB.cadastrarJogador (jogador);
		System.out.println ("Nome: " + jogador.getNome ());
		System.out.println ("Senha: " + jogador.getSenha ());


	}

	public boolean verificaNome(Jogador jogador){


		int qtd = jogadorDB.consultarNome (jogador.getNome ());

		boolean existe = true;

		System.out.println ("TesteNull:" + qtd);

		if (qtd != 0){
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
