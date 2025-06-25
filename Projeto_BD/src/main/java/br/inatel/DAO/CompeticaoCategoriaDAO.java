package br.inatel.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompeticaoCategoriaDAO extends ConnectionDAO {

    public boolean insert(int idCompeticao, int idCategoria) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Competições_has_Categorias (Competições_id, Categorias_id) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCompeticao);
            pst.setInt(2, idCategoria);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir relação Competição-Categoria: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int idCompeticao, int idCategoria) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Competições_has_Categorias WHERE Competições_id = ? AND Categorias_id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCompeticao);
            pst.setInt(2, idCategoria);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar relação Competição-Categoria: " + e.getMessage());
        }

        return success;
    }

    public List<String> selectAll() {
        connectToDb();
        List<String> lista = new ArrayList<>();

        String sql = "SELECT Competições_id, Categorias_id FROM Competições_has_Categorias";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int idComp = rs.getInt("Competições_id");
                int idCat = rs.getInt("Categorias_id");
                lista.add("Competição ID: " + idComp + " - Categoria ID: " + idCat);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar relações: " + e.getMessage());
        }

        return lista;
    }
}
