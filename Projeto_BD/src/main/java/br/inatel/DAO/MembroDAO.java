package br.inatel.DAO;

import br.inatel.Model.Membro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembroDAO extends ConnectionDAO {

    public boolean insert(Membro m) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Membros (Nome, Periodo, Curso, Categorias_id) VALUES (?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, m.getNome());
            pst.setInt(2, m.getPeriodo());
            pst.setString(3, m.getCurso());
            pst.setInt(4, m.getCategoriaId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Membro: " + e.getMessage());
        }

        return success;
    }

    public boolean update(Membro m) {
        connectToDb();
        boolean success = false;

        String sql = "UPDATE Membros SET Nome = ?, Periodo = ?, Curso = ?, Categorias_id = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, m.getNome());
            pst.setInt(2, m.getPeriodo());
            pst.setString(3, m.getCurso());
            pst.setInt(4, m.getCategoriaId());
            pst.setInt(5, m.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Membro: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int id) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Membros WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Membro: " + e.getMessage());
        }

        return success;
    }

    public List<Membro> selectAll() {
        connectToDb();
        List<Membro> lista = new ArrayList<>();

        String sql = "SELECT * FROM Membros";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Membro m = new Membro();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("Nome"));
                m.setPeriodo(rs.getInt("Periodo"));
                m.setCurso(rs.getString("Curso"));
                m.setCategoriaId(rs.getInt("Categorias_id"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Membros: " + e.getMessage());
        }

        return lista;
    }
}
