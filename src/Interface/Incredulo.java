package Interface;

import Database.DatabaseSingleton;
import Personal.Personal;
import Personal.PersonalDAOimpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Incredulo extends JFrame {
    Personal comboboxSelected = new Personal();
    public Incredulo() throws SQLException {
        setSize(400, 380);
        setTitle("Ingreso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        PersonalDAOimpl personalDAO= new PersonalDAOimpl(dbInstance.getConnection());


        ArrayList<Personal> array = personalDAO.obtenerTodos();

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Desactivar edición de celdas
                return false;
            }
        };
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Direccion");

        for (Personal p : array) {
            model.addRow(new Object[]{p.getNombre(), p.getApellido(), p.getDireccion()});
        }



        JTable tabla = new JTable(model);
        JButton btn = new JButton("Crear Nuevo");

        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabla.getSelectedRow();
                    if (row != -1) {
                        Personal personaSeleccionada = array.get(row);
                        // Muestra el JOptionPane con la información de la persona
                        JOptionPane.showMessageDialog(null, "Información de la Persona: " + personaSeleccionada);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabla);

        JComboBox<String> comboBox = new JComboBox<>();
        for (Personal p : array) {
            comboBox.addItem(p.getNombre());
        }
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = comboBox.getSelectedIndex();
                if (row != -1) {
                    comboboxSelected  = array.get(row);
                }
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "La persona que seleccionaste es: " + comboboxSelected.getNombre());
            }
        });
        this.add(comboBox, BorderLayout.EAST);

        this.add(btn, BorderLayout.SOUTH);
        this.add(sp, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
}
