
import Connection.Jdbc;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Jdbc db = new Jdbc();
        new Login(db);

        // TODO:
        //
        // -> ana sayfa :
        // --> tarihe göre sırala
        // --> iconlar
        //
        // -> yeni randevu :
        // --> bir kişi aynı gün aynı poliklinikten sadece bir randevu alabir yap
        // -->[bug] randevu alırken pol değişince default a seans cıkartırıyor
        //

    }
}
