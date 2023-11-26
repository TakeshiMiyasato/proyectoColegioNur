package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VistaAdministrativo extends JFrame {
    private JButton materias;
    private JButton personales;
    private JButton aulas;
    private JButton horariosClases;

    public VistaAdministrativo()  {
        super("Administarción");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        materias = new JButton("Materias");
        materias.setBounds(200, 150, 80, 30);
        add(materias);
        personales = new JButton("Personal");
        personales.setBounds(200, 180, 80, 30);
        add(personales);
        aulas = new JButton("Aulas");
        aulas.setBounds(200, 210, 80, 30);
        add(aulas);
        horariosClases = new JButton("Horarios / Clases");
        horariosClases.setBounds(200, 240, 80, 30);
        add(horariosClases);

        materias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VistaMateriasAdministrativo vistaMaterias= null;
                try {
                    vistaMaterias = new VistaMateriasAdministrativo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                vistaMaterias.setVisible(true);



            }
        });
        personales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaPersonal vistaPersonal = null;
                try {
                    vistaPersonal = new VistaPersonal();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                vistaPersonal.setVisible(true);

            }
        });
        aulas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
