
import Connection.Jdbc;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Jdbc db = new Jdbc();
        new Login(db);

        // TODO:
        //
        // -> admin sayfası:
        // --> güncelleme tusları
        //

    }
}
