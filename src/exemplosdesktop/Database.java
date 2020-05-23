/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplosdesktop;

import java.sql.*;

/**
 *
 * @author wolfi
 */
public class Database {

    private Connection conexao = null;

    public Database() {
        reconecta();
    }

    public boolean isConnected() {
        return conexao != null;
    }

    public void reconecta() {
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
        try {

            Class.forName(nomeDriver).newInstance();
            conexao = DriverManager.getConnection(localBancoDados, usuario, senha);

            /*
            if (conexao != null) {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

                while (rs.next()) {
                    System.out.println(rs.getString("codigo") + "   " + rs.getString("nome"));
                }

            } else {
                System.out.println("Problemas na conexão com o banco de dados!");
            }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConexao() {
        return conexao;
    }

    public ResultSet executaQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement st = conexao.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean validaUsuarioSenha(String usuario, String senha) {
        boolean resp = false;
        try {
            ResultSet rs = executaQuery("SELECT nome, senha FROM usuarios where nome='" + usuario + "' and senha = '" + senha + "'");
            resp = rs.next();
        } catch (Exception e) {
        }

        return resp;
    }
}
