package Dao;

import entity.Jogador;

public interface JogadorDAO {

    Jogador consultarJogador(String nome, String senha);
    void cadastrarJogador(Jogador jogador);
    String consultarNome (String nome);
}

