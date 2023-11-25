package ClasesDAO;




import java.sql.SQLException;
import java.util.ArrayList;

public interface ClaseDAO {
    void insertar(Clase clase) throws SQLException;
    void eliminar(int id) throws SQLException;
    void modificar(Clase clase) throws SQLException;
    ArrayList<Clase> obtenerClasesXMateria(int id) throws SQLException;
    ArrayList<Clase> obtenertodos() throws SQLException;
    ArrayList<Clase> obtenerClasesXAula(int id) throws SQLException;


}
