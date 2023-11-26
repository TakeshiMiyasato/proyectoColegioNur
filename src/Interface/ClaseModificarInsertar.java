package Interface;

import ClasesDAO.Clase;
import ClasesDAO.ClaseDAOImpl;
import Database.DatabaseSingleton;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ClaseModificarInsertar extends JFrame {
    private JLabel aula;
    private JLabel materia;
    private JLabel hora_inicio;
    private JLabel hora_final;
    private JTextField txtHoraInicio;
    private JTextField txtHoraFinal;


    public ClaseModificarInsertar(Clase clase) throws SQLException {
        setSize(700, 314);
        setTitle("Vista Clases");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        ClaseDAOImpl claseDAO = new ClaseDAOImpl(dbInstance.getConnection());

        aula= new JLabel("Aula");     // 2
        materia= new JLabel("Materia");   // 5
        hora_inicio= new JLabel("Hora Inicio");  // 25/04/2024 18:00
        hora_final = new JLabel("Hora Final");   // 25/04/2024 20:00
        txtHoraInicio = new JTextField();
        txtHoraFinal= new JTextField();



    }

}
