package AulaDAO;

import Personal.Personal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AulaDAO {
    void insertar(Aula aula) throws SQLException;
    ArrayList<Aula> obtenerTodos() throws SQLException;
    Aula obtenerAulas(int id) throws SQLException;
    void modificar(Aula aula) throws SQLException;
    void eliminar(int id) throws SQLException;


}
