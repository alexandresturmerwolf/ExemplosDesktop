/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplosdesktop.entidades;

/**
 *
 * @author wolfi
 */
public class Alienigenas {
    private int id;
    private String nome;
    private int tipo;
    private int altura;
    private String cor;       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Alienigenas(int id, String nome, int tipo, int altura, String cor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.altura = altura;
        this.cor = cor;
    }
    
    public Alienigenas(String nome, int tipo, int altura, String cor) {
        this.nome = nome;
        this.tipo = tipo;
        this.altura = altura;
        this.cor = cor;
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
}
