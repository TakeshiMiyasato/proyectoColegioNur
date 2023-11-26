package Interface;
import Database.DatabaseSingleton;
import Materia.Materia;
import Materia.MateriaDAOimpl;
import Materia.MateriaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaMateriasAdministrativo extends JFrame {
    public VistaMateriasAdministrativo() throws SQLException{
        setSize(400, 380);
        setTitle("Ingreso");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        MateriaDAOimpl materiaDAOimpl= new MateriaDAOimpl(dbInstance.getConnection());


        ArrayList<Materia> array = materiaDAOimpl.obtenerTodos();

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Desactivar edición de celdas
                return false;
            }
        };
        model.addColumn("Nombre");
        model.addColumn("profesorId");
        model.addColumn("gestion");


        for (Materia p : array) {
            model.addRow(new Object[]{p.getNombre(), p.getNombreProfesor(), p.getGestion()});
        }



        JTable tabla = new JTable(model);
        JButton btn = new JButton("Crear Nuevo");

        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabla.getSelectedRow();
                    if (row != -1) {
                        Materia materiaSeleccionada = array.get(row);
                        // Muestra el JOptionPane con la información de la persona
                        JOptionPane.showMessageDialog(null, "Información de la Persona: " + materiaSeleccionada);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabla);
        this.add(btn, BorderLayout.SOUTH);
        this.add(sp, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }



}
