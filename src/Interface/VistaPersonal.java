package Interface;

import Database.DatabaseSingleton;
import Personal.Personal;
import Personal.PersonalDAOimpl;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaPersonal extends JFrame {
    private JLabel nombre;
    private JLabel apellido;
    private JLabel direccion;
    private JLabel ciId;

    public VistaPersonal()throws SQLException {
        super("Personal");
        setSize(800, 800);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        PersonalDAOimpl personalDA= new PersonalDAOimpl(dbInstance.getConnection());
        ArrayList<Personal> mostrar = personalDA.obtenerTodos();

        nombre = new JLabel("nombre");
        nombre.setBounds(50,40,50,50);
        add(nombre);

        apellido = new JLabel("apellido");
        apellido.setBounds(150,40,50,50);
        add(apellido);

        direccion=new JLabel("direccion");
        direccion.setBounds(300,40,80,50);
        add(direccion);

        ciId=new JLabel("ciId");
        ciId.setBounds(450,40,40,50);
        add(ciId);

        int y=70;
        for (Personal p:mostrar) {
            JLabel lb = new JLabel(p.getNombre());
            JLabel lb1 = new JLabel(p.getApellido());
            JLabel lb2 = new JLabel(p.getDireccion());
            JLabel lb3 = new JLabel(Integer.toString(p.getCiId()));
            lb.setBounds(50 ,y, 300, 15);
            lb1.setBounds(150 ,y, 300, 15);
            lb2.setBounds(300,y,300,15);
            lb3.setBounds(450,y,300,15);
            this.add(lb);
            this.add(lb1);
            this.add(lb2);
            this.add(lb3);
            y = y + 20;
        }
        this.setVisible(true);
    }
}
