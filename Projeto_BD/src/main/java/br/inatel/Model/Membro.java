package br.inatel.Model;

public class Membro {
    private int id;
    private String nome;
    private int periodo;
    private String curso;
    private int categoriaId;

    public Membro() {}

    public Membro(String nome, int periodo, String curso, int categoriaId) {
        this.nome = nome;
        this.periodo = periodo;
        this.curso = curso;
        this.categoriaId = categoriaId;
    }

    public Membro(int id, String nome, int periodo, String curso, int categoriaId) {
        this.id = id;
        this.nome = nome;
        this.periodo = periodo;
        this.curso = curso;
        this.categoriaId = categoriaId;
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

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}
