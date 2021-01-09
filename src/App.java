
import Connection.Jdbc;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Jdbc db = new Jdbc();
        new Login(db);

        // TODO:
        //
        // -> register :
        // --> tc cut of range hatası
        //
        // -> yeni randevu :
        // --> bir kişi aynı gün aynı poliklinikten sadece bir randevu alabir yap
        //

    }
}
