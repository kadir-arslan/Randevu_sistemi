import Connection.Jdbc;
import User.User;
import User.Hasta;
import Gui.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Jdbc db = new Jdbc();
        Login n = new Login(db);

        // TODO:
        // kayıt olurken :
        // -- tc ile zaten kayıt olunmuşsa zanten kayıt olunmuş hatası
        // -- tc yerine string girilirse hata
        //
        // login olurken:
        // -- şifre dogrulandiğinda ana sayfa oluşturma
        // -- userı nerde oluşturucağına karar ver
        //
        // -> ana sayfa :
        // -- tablolara degerleri db çekmek
        // -- çekilen değerlerin işlenmesi
        //
        //
        //
        // -> yeni randevu :
        // --tamammı
        //
        //

    }
}
