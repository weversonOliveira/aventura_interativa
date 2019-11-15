package control;

import entity.Jogador;
import java.util.ArrayList;
import java.util.List;

public class ControlTelaLogin {

	private List<Jogador> listaJogador = new ArrayList<>();
	

	public boolean login(Jogador jogador) {
		
		System.out.println(jogador.getNome() + " chegou até o login");
		boolean existe = false;
		for (Jogador j : listaJogador) {
			if ((jogador.getNome().equals(j.getNome())) && (jogador.getSenha().equals(j.getSenha()))) {
				System.out.println("Existe " + " Lista: " + j.getNome() + " Tela: " + jogador.getNome());
				existe = true;
			} else {
				System.out.println("Nao existe " + " Lista: " + j.getNome() + " Tela: " + jogador.getNome());
			}
			System.out.println("");
		}
		return existe;
	}

	public void cadastrar(Jogador jogador) {

		listaJogador.add(jogador);
		System.out.println("nome: " + jogador.getNome());
		System.out.println("senha: " + jogador.getSenha());

	}

	public static boolean verificaIgualdade(String primeira, String segunda) {
		boolean resposta = false;
		if (primeira.equals(segunda)) {
			resposta = true;
		}

		return resposta;
	}

}