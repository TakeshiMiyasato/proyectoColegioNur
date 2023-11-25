package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSingleton {
    // Singleton es un patron de diseño creacional que permite la creacion de una sola instancia
    // de un objeto, negando la creacion de mas instancias del mismo
    private static DatabaseSingleton instance;
    private Connection connection;
    private Statement statement;

    private final String url = "jdbc:mysql://localhost:3306/Colegio";
    private final String user = "root";
    private final String password = "root";

    private DatabaseSingleton() throws SQLException {
        connection = DriverManager.getConnection(url, user, password); //Crear conexion a MySQL
        statement = connection.createStatement();
        System.out.println("Conexion exitosa");
    }

    public static DatabaseSingleton getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DatabaseSingleton.class) {
                if (instance == null) {
                    instance = new DatabaseSingleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
