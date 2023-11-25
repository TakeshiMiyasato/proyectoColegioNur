package Notas;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NotaDAO {
    void insertar(Nota notas) throws SQLException;
    ArrayList<Nota> obtenerNotasXMateria(int materiaId ) throws SQLException;
    Nota obtenerNotaXPersona(int id) throws SQLException;
    void modificar(Nota notas) throws SQLException;

}
