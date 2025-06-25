package br.inatel.DAO;

import br.inatel.Model.Capitao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CapitaoDAO extends ConnectionDAO {

    public boolean insert(Capitao c) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Capitães (Nome) VALUES (?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Capitão: " + e.getMessage());
        }

        return success;
    }

    public boolean update(Capitao c) {
        connectToDb();
        boolean success = false;

        String sql = "UPDATE Capitães SET Nome = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setInt(2, c.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Capitão: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int id) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Capitães WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Capitão: " + e.getMessage());
        }

        return success;
    }

    public List<Capitao> selectAll() {
        connectToDb();
        List<Capitao> lista = new ArrayList<>();

        String sql = "SELECT * FROM Capitães";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Capitao c = new Capitao();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Capitães: " + e.getMessage());
        }

        return lista;
    }
}
