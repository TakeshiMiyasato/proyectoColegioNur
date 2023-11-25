package Materia;

import Personal.Personal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MateriaDAO {
    void insertar(Materia materia) throws SQLException;
    ArrayList<Materia> obtenerTodos() throws SQLException;
    Materia obtenerMateria(int id) throws SQLException;
    void modificar(Materia materia) throws SQLException;
    void eliminar(int id) throws SQLException;
}
