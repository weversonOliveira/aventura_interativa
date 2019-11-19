package Dao;

import entity.Jogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogadorDB implements JogadorDAO {

    private static final String URL="jdbc:mariadb://localhost:3306/AventuraInterativa?allowMultiQueries=true";
    private static final String USER="root";
    private static final String PASS="";

    @Override
    public Jogador consultarJogador(String nome, String senha) {

        Jogador jogador = new Jogador ();

        try {

            Connection connection=DriverManager.getConnection (URL, USER, PASS);
            String sql="SELECT * FROM Jogador"
                    + " WHERE nomeJogador LIKE ?"
                    + "AND senhaJogador LIKE ?";

            PreparedStatement preparedStatement=connection.prepareStatement (sql);
            preparedStatement.setString (1, "%" + nome + "%");
            preparedStatement.setString (2, "%" + senha + "%");

            ResultSet consultaNomeSenha = preparedStatement.executeQuery ();

            while (consultaNomeSenha.next ()) {

                jogador.setNome (consultaNomeSenha.getString ("nomeJogador"));
                System.out.println ("NomeDB:"+ jogador.getNome ());
                jogador.setSenha (consultaNomeSenha.getString ("senhaJogador"));
                System.out.println ("SenhaDB:"+ jogador.getNome ());
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return jogador;
    }

    @Override
    public void cadastrarJogador (Jogador jogador){
        try {
            Connection connection=DriverManager.getConnection (URL, USER, PASS);
            String sql="INSERT INTO Jogador "
                    + "(nomeJogador, senhaJogador)"
                    + " VALUES (?, ?)";
            PreparedStatement preparedStatement=connection.prepareStatement (sql);
            preparedStatement.setString (1, jogador.getNome ());
            preparedStatement.setString (2, jogador.getSenha ());
            preparedStatement.executeUpdate ();
            connection.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public String consultarNome(String nome) {

        String nomeDoBanco = "";
        try {

            Connection connection=DriverManager.getConnection (URL, USER, PASS);
            String sql="SELECT * FROM Jogador"
                    + " WHERE nomeJogador LIKE ?";

            PreparedStatement preparedStatement=connection.prepareStatement (sql);
            preparedStatement.setString (1, "%" + nome + "%");

            ResultSet consultaNome = preparedStatement.executeQuery ();

            //omeDoBanco = consultaNome.getString ("nomeJogador");

            nomeDoBanco = consultaNome.getString ("nomeJogador");
            System.out.println ("NomeDBVerificação:"+ nomeDoBanco);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return nomeDoBanco;

    }
}
