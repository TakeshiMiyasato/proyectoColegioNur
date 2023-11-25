package AulaDAO;

import Personal.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; //Data Access Object

public class AulaDAOimpl implements AulaDAO {
    private final Connection connection;

    public AulaDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Aula aula) throws SQLException {
        String sql = "INSERT INTO aulas (denominacion ) " +
                "VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, aula.getDenominacion());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public ArrayList<Aula> obtenerTodos() throws SQLException {
        ArrayList<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM aulas";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Aula aula = new Aula();

            aula.setId(resultSet.getInt("id"));
            aula.setDenominacion(resultSet.getString("denomiacion"));

        }
        resultSet.close();
        statement.close();

        return aulas;
    }

    @Override
    public Aula obtenerAulas(int id) throws SQLException {

        String sql = "SELECT * FROM aulas WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Aula aula = new Aula();
            aula.setId(resultSet.getInt("id"));
            aula.setDenominacion(resultSet.getString("denominacion"));

            resultSet.close();
            statement.close();
            return aula;
        } else {
            return null;
        }
    }


    @Override
    public void modificar(Aula aula) throws SQLException {
        String sql = "UPDATE aulas SET denominacion = ? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, aula.getDenominacion());
        statement.close();
    }


    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM aulas WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();

    }
}
