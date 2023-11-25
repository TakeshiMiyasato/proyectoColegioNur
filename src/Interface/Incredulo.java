package Interface;

import Database.DatabaseSingleton;
import Personal.Personal;
import Personal.PersonalDAOimpl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Incredulo extends JFrame {
    public Incredulo() throws SQLException {
        setSize(400, 380);
        setTitle("Ingreso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        PersonalDAOimpl personalDAO= new PersonalDAOimpl(dbInstance.getConnection());

        ArrayList<Personal> array = personalDAO.obtenerTodos();
        int y = 0;
        for (Personal p: array) {
            JLabel lb = new JLabel(p.getNombre());
            lb.setBounds(0 ,y, 300, 30);
            this.add(lb);
            y = y + 40;
        }
        this.setVisible(true);
    }
}
