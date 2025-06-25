package br.inatel.Model;

public class CompeticaoCategoria {
    private int competicaoId;
    private int categoriaId;

    public CompeticaoCategoria() {}

    public CompeticaoCategoria(int competicaoId, int categoriaId) {
        this.competicaoId = competicaoId;
        this.categoriaId = categoriaId;
    }

    public int getCompeticaoId() { return competicaoId; }
    public void setCompeticaoId(int competicaoId) { this.competicaoId = competicaoId; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
}
