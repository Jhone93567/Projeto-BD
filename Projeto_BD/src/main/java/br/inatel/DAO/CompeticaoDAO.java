package br.inatel.DAO;

import br.inatel.Model.Capitao;
import br.inatel.Model.Competicao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompeticaoDAO extends ConnectionDAO {

    public boolean insert(Competicao c) {
        connectToDb();
        boolean success = false;

        String sql = "INSERT INTO Competições (Nome, Lugar, Data) VALUES (?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getLugar());
            pst.setString(3, c.getData());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Competição: " + e.getMessage());
        }

        return success;
    }

    public boolean update(Competicao c) {
        connectToDb();
        boolean success = false;

        String sql = "UPDATE Competições SET Nome = ?, Lugar = ?, Data = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getLugar());
            pst.setString(3, c.getData());
            pst.setInt(4, c.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Competição: " + e.getMessage());
        }

        return success;
    }

    public boolean delete(int id) {
        connectToDb();
        boolean success = false;

        String sql = "DELETE FROM Competições WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Competição: " + e.getMessage());
        }

        return success;
    }

    public List<Competicao> selectAll() {
        connectToDb();
        List<Competicao> lista = new ArrayList<>();

        String sql = "SELECT * FROM Competições";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Competicao c = new Competicao();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                c.setLugar(rs.getString("Lugar"));
                c.setData(rs.getString("Data"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar Competições: " + e.getMessage());
        }

        return lista;
    }

    public Competicao selectById(int id) {
        connectToDb();
        Competicao c = null;

        String sql = "SELECT * FROM Competições WHERE id = ?";

        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Competicao(
                        rs.getInt("id"),
                        rs.getString("Nome"),
                        rs.getString("Lugar"),
                        rs.getString("Data")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar por ID" + e.getMessage());
        }

        return c;
    }
}
