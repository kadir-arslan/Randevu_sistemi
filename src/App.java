
import javax.swing.JOptionPane;

import Connection.Jdbc;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Jdbc.connect();
            new Login();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error !");
            e.printStackTrace();
        }
    }
}
