package Interface;import Database.DatabaseSingleton;
import Materia.Materia;
import Materia.MateriaDAOimpl;
import Personal.Personal;
import Personal.PersonalDAOimpl;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaMaterias extends JFrame {

    private JLabel lbl_id ;
    private JLabel lbl_nombre ;
    private JLabel lbl_profesorId ;
    private JButton btn_eliminar ;
    private JButton btn_modificar ;
    private JButton btn_crear;


    public  VistaMaterias()throws SQLException {



        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);




        lbl_id=new JLabel("ID");
        lbl_id.setBounds(100,0,80,30);



        lbl_nombre=new JLabel("Nombre ");
        lbl_nombre.setBounds(0,0,80,30);
        add(lbl_nombre);

        lbl_profesorId =new JLabel("Profesor");
       lbl_profesorId.setBounds(200,0,80,30);
        add(lbl_profesorId);

        btn_crear=new JButton();
        btn_crear.setBounds(300,0,80,30);
        add(btn_crear);

        btn_eliminar=new JButton();
        btn_eliminar.setBounds(300,0,80,30);
        add(btn_eliminar);




        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        MateriaDAOimpl materiaDAOimpl= new MateriaDAOimpl(dbInstance.getConnection());

        ArrayList<Materia> array = materiaDAOimpl.obtenerTodos();
        int y = 0;
        for (Materia m: array) {
            JLabel lb = new JLabel(m.getNombre());
            lb.setBounds(0 ,y, 300, 30);
            this.add(lb);

            y = y + 40;


        }

        int y2= 0;
        for (Materia m: array) {
            JLabel lb = new JLabel(m.getNombreProfesor());
            lb.setBounds(200 ,y2, 300, 30);
            this.add(lb);

            y2 = y2 + 40;


        }



        this.setVisible(true);


    }

}
