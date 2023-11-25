package Interface;

import Database.DatabaseSingleton;
import Personal.Personal;
import SeguridadDAO.Seguridad;
import SeguridadDAO.SeguridadDAOimpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Personal.PersonalDAOimpl;

public class Login extends JFrame {
    private JLabel contra;
    private JTextField txtContra;
    private JLabel usuario;
    private JTextField txtUsuario;
    private JLabel titulo;
    private JButton aceptar;


    public Login(SeguridadDAOimpl seguridadDAOimpl) throws SQLException {
        setSize(400, 380);
        setTitle("Ingreso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
        PersonalDAOimpl personalDAO= new PersonalDAOimpl(dbInstance.getConnection());

        titulo = new JLabel("Colegio luz y Saber");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(110, 20, 300, 30);
        add(titulo);

        contra = new JLabel("Contraseña");
        contra.setBounds(100, 150, 80, 30);
        contra.setFont(new Font("Arial", Font.BOLD, 12));
        add(contra);

        usuario = new JLabel("Usuario");
        usuario.setFont(new Font("Arial", Font.BOLD, 12));
        usuario.setBounds(100, 90, 80, 30);
        add(usuario);


        txtUsuario = new JTextField();
        txtUsuario.setBounds(190, 90, 100, 30);
        add(txtUsuario);

        txtContra = new JTextField();
        txtContra.setBounds(190, 150, 100, 30);
        add(txtContra);

        aceptar = new JButton("aceptar");
        aceptar.setBounds(160, 230, 80, 30);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtContra.getText().isEmpty() || txtUsuario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " Rellena los campos  ");

                } else {
                    try {
                        Seguridad seguridad = seguridadDAOimpl.login(txtUsuario.getText(), txtContra.getText());
                        if(seguridad!=null){
                            Personal personal= personalDAO.obtenerPersonal(seguridad.getPersonalId());
                            if (personal.getRolId()==2){
                                JOptionPane.showMessageDialog(null, "este es un profesor");
                            } else  {
                                JOptionPane.showMessageDialog(null, "este es un administrativo");

                            }
                        }else {
                            JOptionPane.showMessageDialog(null,"no se encuentra");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                }
            }
        });
        add(aceptar);

    }

}
