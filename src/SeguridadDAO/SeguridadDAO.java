package SeguridadDAO;

import Personal.Personal;

import java.sql.SQLException;

public interface SeguridadDAO {

    Seguridad login (String username, String contrasenia) throws SQLException;

    void registro(Seguridad seguridad) throws SQLException;

}
