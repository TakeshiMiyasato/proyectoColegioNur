package Notas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotaDAOimpl implements NotaDAO {
    private final Connection connection;

    public NotaDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertar(Nota notas) throws SQLException {
        String sql = "INSERT INTO notas (estudianteId,materiaId,trimestre_1,trimestre_2,trimestre_3) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, notas.getEstudianteId());
        statement.setInt(2, notas.getMateriaId());
        statement.setInt(3, notas.getTrimestre_1());
        statement.setInt(4, notas.getTrimestre_2());
        statement.setInt(5, notas.getTrimestre_3());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public ArrayList<Nota> obtenerNotasXMateria(int materiaId) throws SQLException {
        ArrayList<Nota> notas = new ArrayList<>();
        String sql = "SELECT p.nombre, p.apellido,n.* FROM personal p join notas n on n.estudianteId=p.id WHERE materiaId = ?";
        //select p.nombreProducto,c.nombreCategoria from productos p join categoriaProductos c on p.idCategoria = c.idCategoria;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, materiaId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Nota nota = new Nota();
            nota.setId(resultSet.getInt("id"));
            nota.setEstudianteId(resultSet.getInt("estudianteId"));
            nota.setMateriaId(resultSet.getInt("materiaId"));
            nota.setTrimestre_1(resultSet.getInt("trimestre_1"));
            nota.setTrimestre_2(resultSet.getInt("trimestre_2"));
            nota.setTrimestre_3(resultSet.getInt("trimestre_3"));
            nota.setNombreCompleto(resultSet.getString("nombreCompleto"));
            notas.add(nota);
        }
        resultSet.close();
        statement.close();
        return notas;
    }
    @Override
    public Nota obtenerNotaXPersona(int id) throws SQLException {
        String sql = "SELECT * FROM notas WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            Nota not = new Nota();
            not.setId(resultSet.getInt("id"));
            not.setEstudianteId(resultSet.getInt("estudianteId"));
            not.setMateriaId(resultSet.getInt("materiaId"));
            not.setTrimestre_1(resultSet.getInt("trimestre_1"));
            not.setTrimestre_2(resultSet.getInt("trimestre_2"));
            not.setTrimestre_3(resultSet.getInt("trimestre_3"));
            resultSet.close();
            statement.close();
            return not;
        }else {
            return null;
        }
    }

    @Override
    public void modificar(Nota notas) throws SQLException {
        String sql = "UPDATE notas SET estudianteId = ?, materiaId= ?, trimestre_1=?, trimestre_2 = ?, trimestre_3=? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, notas.getEstudianteId());
        statement.setInt(2, notas.getMateriaId());
        statement.setInt(3, notas.getTrimestre_1());
        statement.setInt(4, notas.getTrimestre_2());
        statement.setInt(5, notas.getTrimestre_3());
        statement.setInt(6,notas.getId());
        statement.executeUpdate();
        statement.close();

    }
}
