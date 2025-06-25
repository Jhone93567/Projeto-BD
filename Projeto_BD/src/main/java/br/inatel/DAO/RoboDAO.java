package br.inatel.DAO;

import br.inatel.Model.Capitao;
import br.inatel.Model.Robo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoboDAO extends ConnectionDAO {

    public boolean insert(Robo r) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Robos (Nome, Categorias_id) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, r.getNome());
            pst.setInt(2, r.getCategoriaId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Robo: " + e.getMessage());
        }

        return success;
    }

    public boolean update(Robo r) {
        connectToDb();
        boolean success = false;

        String sql = "UPDATE Robos SET Nome = ?, Categorias_id = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, r.getNome());
            pst.setInt(2, r.getCategoriaId());
            pst.setInt(3, r.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Robo: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int id) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Robos WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Robo: " + e.getMessage());
        }

        return success;
    }

    public List<Robo> selectAll() {
        connectToDb();
        List<Robo> lista = new ArrayList<>();

        String sql = "SELECT * FROM Robos";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Robo r = new Robo();
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("Nome"));
                r.setCategoriaId(rs.getInt("Categorias_id"));
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Robos: " + e.getMessage());
        }

        return lista;
    }

    public Robo selectById(int id) {
        connectToDb();
        Robo c = null;

        String sql = "SELECT * FROM Robos WHERE id = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Robo(
                        rs.getInt("id"),
                        rs.getString("Nome"),
                        rs.getInt("Categorias_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar por ID" + e.getMessage());
        }

        return c;
    }
}
