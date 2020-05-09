/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplosdesktop;

import java.sql.*;

public class SimpleDatabase {

    public static void main(String[] args) {

        // ============== Exemplo com postgres ==========================
        String nomeDriver = "org.postgresql.Driver";
        String localBancoDados = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "admin";

        // ============== Exemplo com mysql/mariadb =======================
        //String nomeDriver = "org.mariadb.jdbc.Driver";
        //String localBancoDados = "jdbc:mariadb://localhost:3306/bancodados";
        //String usuario = "root";
        //String senha = "admin";
        Connection conexao = null;

        try {

            Class.forName(nomeDriver).newInstance();
            conexao = DriverManager.getConnection(localBancoDados, usuario, senha);

            if (conexao != null) {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

                while (rs.next()) {
                    System.out.println(rs.getString("codigo") + "   " + rs.getString("nome"));
                }

            } else {
                System.out.println("Problemas na conexão com o banco de dados!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
