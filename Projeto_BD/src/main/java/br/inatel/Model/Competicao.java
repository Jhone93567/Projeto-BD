package br.inatel.Model;

public class Competicao {
    private int id;
    private String nome;
    private String lugar;
    private String data;

    public Competicao() {}

    public Competicao(String nome, String lugar, String data) {
        this.nome = nome;
        this.lugar = lugar;
        this.data = data;
    }

    public Competicao(int id, String nome, String lugar, String data) {
        this.id = id;
        this.nome = nome;
        this.lugar = lugar;
        this.data = data;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
