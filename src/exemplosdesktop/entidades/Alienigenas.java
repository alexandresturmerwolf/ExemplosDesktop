/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplosdesktop.entidades;

import exemplosdesktop.Database;

/**
 *
 * @author wolfi
 */
public class Alienigenas {

    private Database db = null;

    private int id;
    private String nome;
    private int tipo;
    private int altura;
    private String cor;

    public Alienigenas(Database db) {
        this.db = db;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean insere() {
        boolean ok = false;
        try {
            db.executaSQL("INSERT INTO alienigenas(nome, tipo, altura, cor) VALUES('" + nome + "', '" + tipo + "', '" + altura + "', '" + cor + "')");
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean exclui(int id) {
        boolean ok = false;

        try {
            db.executaSQL("DELETE FROM alienigenas WHERE id='" + id + "'");
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public boolean altera() {
        boolean ok = false;
        try {
            db.executaSQL("UPDATE alienigenas SET "
                    + "nome = '" + nome + "', "
                    + "tipo = '" + tipo + "', "
                    + "altura = '" + altura + "', "
                    + "cor = '" + cor + "' "
                    + "WHERE id = '" + id + "'"
            );
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

}
