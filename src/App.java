import Connection.Jdbc;
import User.User;
import User.Hasta;

public class App {
    public static void main(String[] args) throws Exception {
        Jdbc db = new Jdbc();

        User user = new Hasta("isim", 1, db);
        user.makeAdmin();
        user.
    }
}
