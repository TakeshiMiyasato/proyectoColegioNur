package SeguridadDAO;

import Personal.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeguridadDAOimpl implements SeguridadDAO{

    private final Connection connection;

    public SeguridadDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Seguridad login(String username, String contrasenia) throws SQLException {
        String sql = "select * from seguridad where usuario=? and contrasenia=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, contrasenia);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Seguridad segu = new Seguridad();
            segu.setId(resultSet.getInt("id"));
            segu.setUsuario(resultSet.getString("usuario"));
            segu.setContrasenia(resultSet.getString("contrasenia"));
            segu.setPersonalId(resultSet.getInt("idPersonal"));
            resultSet.close();
            statement.close();
            return segu;
        } else {
            return null;
        }
    }

    @Override
    public void registro(Seguridad seguridad) throws SQLException {
        String sql = "INSERT INTO seguridad (usuario ,contrasenia,personalId)"+
                "VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, seguridad.getUsuario());
        statement.setString(2, seguridad.getContrasenia());
        statement.setInt(3, seguridad.getPersonalId());
        statement.executeUpdate();
        statement.close();
    }
}
