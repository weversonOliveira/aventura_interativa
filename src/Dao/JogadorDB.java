package Dao;

import entity.Jogador;

import java.sql.*;

public class JogadorDB implements JogadorDAO {

    private static final String URL="jdbc:mariadb://localhost:3306/AventuraInterativa?allowMultiQueries=true";
    private static final String USER="root";
    private static final String PASS="";


    @Override
    public Jogador consultarJogador(String nome, String senha) {

//        try {
//            Class.forName ("/home/weverson/AventuraInterativa/src/lib/mariadb-java-client-2.4.4.jar!/org/mariadb/jdbc/Driver.class");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace ();
//        }
        Jogador jogador1=new Jogador ();

        try {

            Connection connection=DriverManager.getConnection (URL, USER, PASS);
            String sql="SELECT * FROM Jogador"
                    + " WHERE nomeJogador LIKE ?"
                    + "AND senhaJogador LIKE ?";

            PreparedStatement preparedStatement=connection.prepareStatement (sql);
            preparedStatement.setString (1, "%" + nome + "%");
            preparedStatement.setString (2, "%" + senha + "%");

            ResultSet resultSet=preparedStatement.executeQuery ();

            while (resultSet.next ()) {

                jogador1.setNome (resultSet.getString ("nomeJogador"));
                System.out.println ("NomeDB:"+ jogador1.getNome ());
                jogador1.setSenha (resultSet.getString ("senhaJogador"));
                System.out.println ("SenhaDB:"+ jogador1.getNome ());
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return jogador1;
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
}
