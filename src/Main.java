import Database.DatabaseSingleton;
import Interface.*;
import Personal.Personal;
import Personal.PersonalDAO;
import Personal.PersonalDAOimpl;
import SeguridadDAO.SeguridadDAOimpl;

import java.sql.SQLException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try{
            DatabaseSingleton dbInstance = DatabaseSingleton.getInstance();
            SeguridadDAOimpl seguridadDAOimpl=new SeguridadDAOimpl(dbInstance.getConnection());
            PersonalDAOimpl personalDAOimpl = new PersonalDAOimpl(dbInstance.getConnection());
//            Incredulo i = new Incredulo();
//
//            Login login=new Login(seguridadDAOimpl);
//            login.setVisible(true);
//            VistaAdministrativo vistaAdministrativo = new VistaAdministrativo();
//            vistaAdministrativo.setVisible(true);
            VistaPersonal vp = new VistaPersonal();
            VistaMaterias vm = new VistaMaterias();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
