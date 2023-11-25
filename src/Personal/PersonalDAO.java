package Personal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonalDAO {
    void insertar(Personal personal) throws SQLException;
    ArrayList<Personal> obtenerTodos() throws SQLException;
    Personal obtenerPersonal(int id) throws SQLException;
    void modificar(Personal personal) throws SQLException;
    void eliminar(int id) throws SQLException;

    ArrayList<Personal> obtenerEstudiantes() throws SQLException;
    ArrayList<Personal> obtenerAdministracion() throws SQLException;


}
