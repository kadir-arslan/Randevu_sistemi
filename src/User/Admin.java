package User;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import Connection.Jdbc;

public class Admin extends Hasta {

  public Admin(String tc, String sifre, Jdbc db) {
    super(tc, sifre, db);
  }

  public void addPol(String polName) {
    try {
      this.db.executeUpdate("INSERT INTO hastane.poliklinik(pol_name) VALUES('" + polName + "');");
    } catch (Exception e) {
    }
  }

  public void deletePol(String polId) {
    try {
      this.db.executeUpdate("DELETE FROM hastane.poliklinik WHERE pol_id = " + polId + ";");
    } catch (Exception e) {
    }
  }

  public ArrayList<String[]> getPolList() {
    ArrayList<String[]> ret = new ArrayList<String[]>();
    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.poliklinik");
      while (result.next()) {
        String[] row = new String[2];
        row[0] = result.getString(1);
        row[1] = result.getString(2);
        ret.add(row);
      }
      return ret;
    } catch (SQLException e) {
      return null;
    }

  }

  public void addDok(String dokName, String polName) {
    try {

      this.db.executeUpdate(
          "INSERT INTO hastane.doktorlar(dok_name , dok_pol_id) VALUES('" + dokName + "'," + getPolId(polName) + ");");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void deleteDok(String dokId) {
    try {
      this.db.executeUpdate("DELETE FROM hastane.doktorlar WHERE dok_id = " + dokId + ";");
    } catch (Exception e) {
    }
  }

  public ArrayList<String[]> getDokList() {
    ArrayList<String[]> ret = new ArrayList<String[]>();

    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.doktorlar;");
      while (result.next()) {
        String[] row = new String[3];
        row[0] = result.getString(1);
        row[1] = result.getString(2);
        row[2] = result.getString(3);
        ret.add(row);
      }

      for (String[] strings : ret) {
        result = this.db.executeQuery("SELECT pol_name FROM hastane.poliklinik WHERE pol_id = " + strings[2] + " ;");
        result.next();
        strings[2] = result.getString(1);// tc den hasta isimine dönüştürme

      }
      return ret;
    } catch (SQLException e) {
      return null;
    }

  }

  @Override
  public ArrayList<String[]> getRandList() {
    ArrayList<String[]> ret = new ArrayList<String[]>();

    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.hafta;");
      ResultSetMetaData rsmd = result.getMetaData();
      while (result.next()) {
        for (int i = 3; i < 16; i++) {
          if (result.getString(i) != null) {
            String[] row = new String[6];

            row[2] = result.getString(2); // tarih sutunu
            row[4] = result.getString(1); // dok_id değerinden poliklink adına
            row[5] = result.getString(1); // dok_id değerinden dok_name değerine
            String saat = rsmd.getColumnName(i).toString().substring(1, 3) + "."
                + rsmd.getColumnName(i).toString().substring(4, 6);
            row[3] = saat;
            String tc = result.getString(i);
            row[1] = tc;
            row[0] = tc;
            ret.add(row);
          }
        }
      }

      for (String[] strings : ret) {
        result = this.db.executeQuery("select isim from  hastane.hastalar where tc = " + strings[0] + " ;");
        result.next();
        strings[0] = result.getString(1);// tc den hasta isimine dönüştürme

      }

      for (String[] strings : ret) {
        result = this.db.executeQuery(
            "SELECT pol_name FROM hastane.poliklinik WHERE pol_id in(SELECT dok_pol_id FROM hastane.doktorlar WHERE dok_id = '"
                + strings[4] + "' );");
        result.next();
        strings[4] = result.getString(1);// dok_id değerinden poliklink adına

      }
      for (String[] strings : ret) {
        result = this.db.executeQuery("SELECT dok_name FROM hastane.doktorlar WHERE dok_id = '" + strings[5] + "';");
        result.next();
        strings[5] = result.getString(1);// dok_id değerinden dok_name değerine

      }

      return ret;
    } catch (SQLException e) {
      return null;
    }
  }

}
