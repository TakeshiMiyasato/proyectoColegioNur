package Interface;

import ClasesDAO.Clase;
import ClasesDAO.ClaseDAOImpl;
import Database.DatabaseSingleton;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaClase extends JFrame {
    public VistaClase() throws SQLException{
        setSize(700, 314);
        setTitle("Vista Clases");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        ClaseDAOImpl claseDAO= new ClaseDAOImpl(dbInstance.getConnection());


        ArrayList<Clase> array = claseDAO.obtenertodos();

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Desactivar edición de celdas
                return false;
            }
        };
        model.addColumn("Aula");
        model.addColumn("Materia");
        model.addColumn("Hora_Inicio");
        model.addColumn("Hora_Final");

        for (Clase c : array) {
            model.addRow(new Object[]{c.getNombreAula(),c.getNombreMateria(),c.getHora_inicio(),c.getHora_final()});
        }


        JTable tabla = new JTable(model);
        JButton btn = new JButton("Crear Nueva");

        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabla.getSelectedRow();
                    if (row != -1) {
                        Clase claseSeleccionada = array.get(row);
                        // Muestra el JOptionPane con la información de la persona
                        JOptionPane.showMessageDialog(null, "Información de la Persona: " + claseSeleccionada);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabla);
        this.add(btn, BorderLayout.SOUTH);
        this.add(sp, BorderLayout.CENTER);
        this.setVisible(true);

    }

}
