package br.inatel.Model;

public class Coordenador {
    private int id;
    private String nome;

    public Coordenador() {}

    public Coordenador(String nome) {
        this.nome = nome;
    }

    public Coordenador(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
