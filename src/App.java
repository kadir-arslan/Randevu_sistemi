
import javax.swing.JOptionPane;

import Connection.Jdbc;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Jdbc db = new Jdbc();
            new Login(db);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error !");
            e.printStackTrace();
        }
    }
}
