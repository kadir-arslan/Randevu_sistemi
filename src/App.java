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
        // -- alperenden yenisii iste isim tc ve sifre olan
        // -- tc ile zaten kayıt olunmuşsa zanten kayıt olunmuş hatası
        // -- tc yerine string girilirse hata
        //
        // login olurken:
        // -- alperenden yenisini iste tc ve sifre olan sifre gözükmeyen kutucuk olsun
        // -- şifre dogrulamadaki hata düzelt
        // -- şifre dogrulandiğinda ana sayfa oluşturma
        // -- userı nerde oluşturucağına karar ver
        //
        // -> ana sayfa
        // -> poliklinik seçme sayfası
        // -> doc seçme sayfası
        // -> seans seçme sayfası
        //

    }
}
