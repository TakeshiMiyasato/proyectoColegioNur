package ClasesDAO;

import Notas.Nota;
import Personal.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClaseDAOImpl implements  ClaseDAO{
    private final Connection connection;

    public ClaseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Clase clase) throws SQLException {
        String sql = "INSERT INTO clase (aulaId,materiaId,hora_inicio,hora_final) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, clase.getAulaId());
        statement.setInt(2, clase.getMateriaId());
        statement.setString(3, clase.getHora_inicio());
        statement.setString(4, clase.getHora_final());
        statement.executeUpdate();
        statement.close();

    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM clases WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public ArrayList<Clase> obtenerClasesXMateria(int id) throws SQLException {

        ArrayList<Clase> clases = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE materiaId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
             Clase clase = new Clase();
            clase.setId(resultSet.getInt("id"));
            clase.setAulaId(resultSet.getInt("aulaId"));
            clase.setMateriaId(resultSet.getInt("materiaId"));
            clase.setHora_inicio(resultSet.getString("hora_inicio"));
            clase.setHora_final(resultSet.getString("hora_final"));

           clases.add(clase);
        }
        resultSet.close();
        statement.close();
        return clases;
    }

    @Override
    public ArrayList<Clase> obtenertodos() throws SQLException {
        ArrayList<Clase> clases = new ArrayList<>();
        String sql = "SELECT * FROM clases";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Clase clase = new Clase();
            clase.setId(resultSet.getInt("id"));
            clase.setAulaId(resultSet.getInt("aulaId"));
            clase.setMateriaId(resultSet.getInt("materiaId"));
            clase.setNombreAula(resultSet.getString("denominacion"));
            clase.setNombreMateria(resultSet.getString("nombre"));
            clase.setHora_inicio(resultSet.getString("hora_inicio"));
            clase.setHora_final(resultSet.getString("hora_final"));
            clases.add(clase);
        }
        resultSet.close();
        statement.close();
        return clases;
    }

    @Override
    public ArrayList<Clase> obtenerClasesXAula(int id) throws SQLException {
        ArrayList<Clase> clases = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE aulaId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Clase clase = new Clase();
            clase.setId(resultSet.getInt("id"));
            clase.setAulaId(resultSet.getInt("aulaId"));
            clase.setMateriaId(resultSet.getInt("materiaId"));
            clase.setNombreAula(resultSet.getString("denominacion"));
            clase.setNombreMateria(resultSet.getString("nombre"));
            clase.setHora_inicio(resultSet.getString("hora_inicio"));
            clase.setHora_final(resultSet.getString("hora_final"));
            clases.add(clase);
        }
        resultSet.close();
        statement.close();
        return clases;
    }

    @Override
    public void modificar(Clase clase) throws SQLException {
        String sql = "UPDATE notas SET aulaId = ?, materiaId= ?, hora_inicio=?, hora_final = ?, trimestre_3=? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, clase.getAulaId());
        statement.setInt(2, clase.getMateriaId());
        statement.setString(3, clase.getHora_inicio());
        statement.setString(4, clase.getHora_final());
        statement.setInt(5,clase.getId());
        statement.executeUpdate();
        statement.close();

    }
}
