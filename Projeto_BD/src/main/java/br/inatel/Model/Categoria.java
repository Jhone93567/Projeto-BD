package br.inatel.Model;

public class Categoria {
    private int id;
    private String nome;
    private int capitaoId;
    private int coordenadorId;

    public Categoria() {}

    public Categoria(String nome, int capitaoId, int coordenadorId) {
        this.nome = nome;
        this.capitaoId = capitaoId;
        this.coordenadorId = coordenadorId;
    }

    public Categoria(int id, String nome, int capitaoId, int coordenadorId) {
        this.id = id;
        this.nome = nome;
        this.capitaoId = capitaoId;
        this.coordenadorId = coordenadorId;
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

    public int getCapitaoId() {
        return capitaoId;
    }

    public void setCapitaoId(int capitaoId) {
        this.capitaoId = capitaoId;
    }

    public int getCoordenadorId() {
        return coordenadorId;
    }

    public void setCoordenadorId(int coordenadorId) {
        this.coordenadorId = coordenadorId;
    }
}
