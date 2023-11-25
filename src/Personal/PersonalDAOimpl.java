package Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalDAOimpl implements PersonalDAO {

    private final Connection connection;

    public PersonalDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Personal personal) throws SQLException {
        String sql = "INSERT INTO personal (nombre,apellido ,direccion , ciId,fecha_nacimiento,rolId ) " +
                "VALUES (?, ?, ?, ?, ?,? )";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, personal.getNombre());
        statement.setString(2, personal.getApellido());
        statement.setString(3, personal.getDireccion());
        statement.setInt(4, personal.getCiId());
        statement.setString(5, personal.getFecha_nacimiento());
        statement.setInt(6, personal.getRolId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public ArrayList<Personal> obtenerTodos() throws SQLException {
        ArrayList<Personal> personals = new ArrayList<>();
        String sql = "SELECT * FROM personal";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Personal personal = new Personal();

            personal.setId(resultSet.getInt("id"));
            personal.setNombre(resultSet.getString("nombre"));
            personal.setApellido(resultSet.getString("apellido"));
            personal.setDireccion(resultSet.getString("direccion"));
            personal.setCiId(resultSet.getInt("ciId"));
            personal.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
            personal.setRolId(resultSet.getInt("rolId"));
            personals.add(personal);
        }
        resultSet.close();
        statement.close();

        return personals;
    }

    @Override
    public Personal obtenerPersonal(int id) throws SQLException {

        String sql = "SELECT * FROM personal WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Personal personal = new Personal();
            personal.setId(resultSet.getInt("id"));
            personal.setNombre(resultSet.getString("nombre"));
            personal.setApellido(resultSet.getString("apellido"));
            personal.setDireccion(resultSet.getString("direccion"));
            personal.setCiId(resultSet.getInt("ciId"));
            personal.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
            personal.setRolId(resultSet.getInt("rolId"));
            resultSet.close();
            statement.close();
            return personal;
        } else {

            return null;
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM personal WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }



    @Override
    public ArrayList<Personal> obtenerEstudiantes() throws SQLException {

        ArrayList<Personal> personals = new ArrayList<>();
        String sql = "select * from personal where rolId=1";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Personal personal = new Personal();
            personal.setId(resultSet.getInt("id"));
            personal.setNombre(resultSet.getString("nombre"));
            personal.setApellido(resultSet.getString("apellido"));
            personal.setDireccion(resultSet.getString("direccion"));
            personal.setCiId(resultSet.getInt("ciId"));
            personal.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
            personal.setRolId(resultSet.getInt("rolId"));
            personals.add(personal);
        }
        resultSet.close();
        statement.close();

        return personals;

    }

    @Override
    public ArrayList<Personal> obtenerAdministracion() throws SQLException {

        ArrayList<Personal> personals = new ArrayList<>();
        String sql = "select * from personal where rolId=3";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Personal personal = new Personal();
            personal.setId(resultSet.getInt("id"));
            personal.setNombre(resultSet.getString("nombre"));
            personal.setApellido(resultSet.getString("apellido"));
            personal.setDireccion(resultSet.getString("direccion"));
            personal.setCiId(resultSet.getInt("ciId"));
            personal.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
            personal.setRolId(resultSet.getInt("rolId"));
            personals.add(personal);
        }
        resultSet.close();
        statement.close();

        return personals;
    }

    @Override
    public void modificar(Personal personal) throws SQLException {
        String sql = "UPDATE personal SET nombre = ?, apellido= ?, direccion= ?, ciId=?, fecha_nacimiento = ?, rolId=? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, personal.getNombre());
        statement.setString(2, personal.getApellido());
        statement.setString(3, personal.getDireccion());
        statement.setInt(4, personal.getCiId());
        statement.setString(5, personal.getFecha_nacimiento());
        statement.setInt(6, personal.getRolId());
        statement.setInt(7,personal.getId());
        statement.executeUpdate();
        statement.close();
    }
}
