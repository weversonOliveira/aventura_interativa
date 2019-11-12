package control;

import entity.Jogador;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControlTelaLogin {

	private List<Jogador> listaJogador = new ArrayList<>();

	public Jogador login(String nome) {

		for (Jogador jogador : listaJogador) {
			if (jogador.getNome().contains(nome)) {
				return jogador;

				// System.out.println (jogador.getNome ());
				// System.out.println (jogador.getSenha ());
			}
		}
		return null;
	}

	public void cadastrar(Jogador jogador) {
		
		for (Iterator<Jogador> iter = listaJogador.iterator(); iter.hasNext();) {
			Jogador jogadorAtual = iter.next();
			
			
			System.out.println(jogadorAtual.getNome());
		
			if (jogador.getNome().toString().equals(j.getNome().toString())) {
			System.out.println("Existe");
			} else {
				listaJogador.add(jogador);
			}
		}
		System.out.println("Jogador Cadastrado");

		for (Iterator<Jogador> iter = listaJogador.iterator(); iter.hasNext();) {
			Jogador jogadorAtual = iter.next();
			System.out.println(jogadorAtual.getNome());
		}

	}

	public static boolean verificaIgualdade(String primeira, String segunda) {
		boolean resposta = false;
		if (primeira.equals(segunda)) {
			resposta = true;
		}

		return resposta;
	}

}