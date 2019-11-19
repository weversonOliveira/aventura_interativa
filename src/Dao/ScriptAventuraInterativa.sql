CREATE DATABASE AventuraInterativa;
USE AventuraInterativa;
CREATE TABLE Jogador (
	 jogadorID      INT  NOT NULL AUTO_INCREMENT,
	 nomeJogador    VARCHAR(10) NOT NULL DEFAULT '',
	 senhaJogador   VARCHAR(12) NOT NULL DEFAULT '',
	 emailJogador   VARCHAR(30),

	 PRIMARY KEY  (jogadorID)
	);
	
