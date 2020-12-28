package User;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.Jdbc;

public class Hasta implements User {

  protected String isim = null;
  protected String tc = null;
  protected String sifre = null;
  protected Jdbc db;

  public Hasta(String isim, String tc, String sifre, Jdbc db) {
    this.isim = isim;
    this.tc = tc;
    this.sifre = sifre;
    this.db = db;
  }

  @Override
  public void getPoliklinikList() {
    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.poliklinik;");
      while (result.next()) {
        String data = "";
        for (int i = 1; i <= 2; i++) {
          data += result.getString(i) + "::";
        }
        System.out.println(data);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void getDoktroList(int pol_id) {
    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.doktorlar WHERE dok_pol_id = '" + pol_id + "';");
      while (result.next()) {
        String data = "";
        for (int i = 1; i <= 3; i++) {
          data += result.getString(i) + "::";
        }
        System.out.println(data);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void getProgramList(int dok_id) {
    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.hafta WHERE h_dok_id = '" + dok_id + "';");
      while (result.next()) {
        String data = "";
        for (int i = 1; i <= 16; i++) {
          data += result.getString(i) + "::";
        }
        System.out.println(data);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void getseans(int dok_id, String saat) {
    try {
      ResultSet result = this.db
          .executeQuery("SELECT s" + saat + " FROM hastane.hafta WHERE h_dok_id = '" + dok_id + "';");
      while (result.next()) {
        System.out.println(result.getString(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
