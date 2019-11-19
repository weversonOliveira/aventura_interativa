package control;

import Dao.JogadorDB;
import entity.Jogador;
import java.util.ArrayList;
import java.util.List;

public class ControlLogin {

	private List<Jogador> listaJogador=new ArrayList<> ();
	private JogadorDB jogadorDB=new JogadorDB ();

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

	public static boolean verificaIgualdade (String primeira, String segunda){
		boolean resposta=false;
		if (primeira.equals (segunda)) {
			resposta=true;
		}
		return resposta;
	}
}
