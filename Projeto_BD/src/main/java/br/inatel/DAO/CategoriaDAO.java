package br.inatel.DAO;

import br.inatel.Model.Categoria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO extends ConnectionDAO {

    public boolean insert(Categoria c) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Categorias (Nome, Capitães_id, Coordenadores_id) VALUES (?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setInt(2, c.getCapitaoId());
            pst.setInt(3, c.getCoordenadorId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Categoria: " + e.getMessage());
        }

        return success;
    }

    public boolean update(Categoria c) {
        connectToDb();
        boolean success = false;

        String sql = "UPDATE Categorias SET Nome = ?, Capitães_id = ?, Coordenadores_id = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setInt(2, c.getCapitaoId());
            pst.setInt(3, c.getCoordenadorId());
            pst.setInt(4, c.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Categoria: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int id) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Categorias WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Categoria: " + e.getMessage());
        }

        return success;
    }

    public List<Categoria> selectAll() {
        connectToDb();
        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT * FROM Categorias";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                c.setCapitaoId(rs.getInt("Capitães_id"));
                c.setCoordenadorId(rs.getInt("Coordenadores_id"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Categorias: " + e.getMessage());
        }

        return lista;
    }
}
