
import Connection.Jdbc;
import User.User;
import User.Hasta;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Jdbc db = new Jdbc();
        new Login(db);

        // TODO:
        // kayıt olurken :
        // -- tc ile zaten kayıt olunmuşsa zanten kayıt olunmuş hatası
        // -- tc yerine string girilirse hata
        //
        // -> ana sayfa :
        // -- tablolara degerleri db çekmek
        // -- çekilen değerlerin işlenmesi

        //
        // -> yeni randevu :
        // --[bug] randevu alırken pol değişince default a seans cıkartırıyor
        //

    }
}
