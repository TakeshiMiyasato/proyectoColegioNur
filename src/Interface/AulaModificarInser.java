package Interface;

import ClasesDAO.ClaseDAOImpl;
import Database.DatabaseSingleton;
import AulaDAO.AulaDAOimpl;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AulaModificarInser extends JFrame {
    private JLabel denominacion = new JLabel("Denomicion");
    public AulaModificarInser()throws SQLException{
        setSize(700, 314);
        setTitle("Vista Clases");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        AulaDAOimpl aulaDAOimpl = new AulaDAOimpl(dbInstance.getConnection());

        denominacion.setBounds(90,90,90,90);
    }

}
