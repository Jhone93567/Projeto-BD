package br.inatel.DAO;

import br.inatel.Model.Capitao;
import br.inatel.Model.Coordenador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorDAO extends ConnectionDAO {

    public boolean insert(Coordenador c) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Coordenadores (Nome) VALUES (?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Coordenador: " + e.getMessage());
        }

        return success;
    }

    public boolean update(Coordenador c) {
        connectToDb();
        boolean success = false;

        String sql = "UPDATE Coordenadores SET Nome = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setInt(2, c.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Coordenador: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int id) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Coordenadores WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Coordenador: " + e.getMessage());
        }

        return success;
    }

    public List<Coordenador> selectAll() {
        connectToDb();
        List<Coordenador> lista = new ArrayList<>();

        String sql = "SELECT * FROM Coordenadores";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Coordenador c = new Coordenador();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Coordenadores: " + e.getMessage());
        }

        return lista;
    }

    public Coordenador selectById(int id) {
        connectToDb();
        Coordenador c = null;

        String sql = "SELECT * FROM Coordenadores WHERE id = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Coordenador(
                        rs.getInt("id"),
                        rs.getString("Nome")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar por ID" + e.getMessage());
        }

        return c;
    }
}
