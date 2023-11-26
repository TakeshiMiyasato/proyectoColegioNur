package Materia;

import Personal.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MateriaDAOimpl implements MateriaDAO {
    private final Connection connection;

    public MateriaDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Materia materia) throws SQLException {
        String sql = "INSERT INTO materias (nombre,profesorId,gestion ) " +
                "VALUES (?, ?, ?, ? )";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, materia.getNombre());
        statement.setInt(2, materia.getProfesorId());
        statement.setInt(3, materia.getGestion());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public ArrayList<Materia> obtenerTodos() throws SQLException {
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "select p.nombre as nombreDocente,m.* from personal p " +
                "join materias m on m.profesorId=p.id ";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Materia materia = new Materia();

            materia.setId(resultSet.getInt("id"));
            materia.setNombre(resultSet.getString("nombre"));
            materia.setProfesorId(resultSet.getInt("profesorId"));
            materia.setGestion(resultSet.getInt("gestion"));
            materia.setNombreProfesor(resultSet.getString("nombreDocente"));
            materias.add(materia);
        }
        resultSet.close();
        statement.close();


        return materias;
    }

    @Override
    public Materia obtenerMateria(int id) throws SQLException {

        String sql = "SELECT * FROM materia WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Materia materia = new Materia();
            materia.setId(resultSet.getInt("id"));
            materia.setNombre(resultSet.getString("nombre"));
            materia.setProfesorId(resultSet.getInt("profesorId"));
            materia.setGestion(resultSet.getInt("gestion"));
            resultSet.close();
            statement.close();
            return materia;
        } else {

            return null;
        }
    }
    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM materia WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public ArrayList<Materia> ObtenerMAteriasProfesor() throws SQLException {
        ArrayList<Materia> materi = new ArrayList<>();
        String sql = "select nombre from materias where profesorId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Materia materia = new Materia();
            materia.setNombre(resultSet.getString("nombre"));
            materi.add(materia);
        }
        resultSet.close();
        statement.close();
        return materi;
    }

    @Override
    public void modificar(Materia materia) throws SQLException {
        String sql = "UPDATE materia SET nombre = ?, profesorId= ?, gestion= ? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, materia.getNombre());
        statement.setInt(2, materia.getProfesorId());
        statement.setInt(3, materia.getGestion());
        statement.setInt(4,materia.getId());
        statement.executeUpdate();
        statement.close();

    }
}
