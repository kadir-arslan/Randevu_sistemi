package User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Connection.Jdbc;

public class Hasta {

  protected String isim = null;
  protected String tc = null;
  protected String sifre = null;
  protected Jdbc db;

  private String selectedpol_id;
  private String selectedpol;
  private String selecteddok_id;
  private String selecteddok;
  private String selectedtarih;
  private String selectedseans;

  public Hasta(String isim, String tc, String sifre, Jdbc db) {
    this.isim = isim;
    this.tc = tc;
    this.sifre = sifre;
    this.db = db;
  }

  public void setSelectedDok(String selecteddok) {
    this.selecteddok = selecteddok;
  }

  public void selectedpol(String selectedpol) {
    this.selectedpol = selectedpol;
  }

  public void selectedseans(String selectedseans) {
    this.selectedseans = selectedseans;
  }

  public void setSelectedtarih(String selectedtarih) {
    this.selectedtarih = selectedtarih;
  }

  public Vector<String> getPoliklinikList() {
    Vector<String> pol = new Vector<String>();

    try {
      ResultSet result = this.db.executeQuery("SELECT * FROM hastane.poliklinik;");
      pol.add("defualt");
      while (result.next()) {
        pol.add(result.getString(2));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pol;
  }

  public Vector<String> getDoktroList(String pol_name) {
    Vector<String> dok = new Vector<String>();
    this.selectedpol = pol_name;

    try {
      ResultSet result = this.db
          .executeQuery("select pol_id FROM hastane.poliklinik where pol_name = '" + pol_name + "';");
      if (result.next()) {
        this.selectedpol_id = result.getString(1);
      }
      ResultSet result2 = this.db
          .executeQuery("SELECT * FROM hastane.doktorlar WHERE dok_pol_id = '" + this.selectedpol_id + "';");
      dok.clear();
      dok.add("defualt");
      while (result2.next()) {
        dok.add(result2.getString(2));
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return dok;

  }

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

  public Vector<String> getseans() {
    Vector<String> seans = new Vector<String>();
    try {
      ResultSet result = this.db.executeQuery("select dok_id From hastane.doktorlar where dok_name = '"
          + this.selecteddok + "' and dok_pol_id = '" + this.selectedpol_id + "'");
      if (result.next()) {
        this.selecteddok_id = result.getString(1);
      }
      result = this.db.executeQuery("select * from hastane.hafta where gun ='" + this.selectedtarih
          + "' and h_dok_id = '" + this.selecteddok_id + "'");
      if (!result.next()) {
        this.db.executeUpdate("INSERT INTO hastane.hafta(h_dok_id,gun) values(" + this.selecteddok_id + ",'"
            + this.selectedtarih + "');");
        result = this.db.executeQuery("select * from hastane.hafta where gun ='" + this.selectedtarih
            + "' and h_dok_id = '" + this.selecteddok_id + "'");
        result.next();
      }
      ResultSetMetaData rsmd = result.getMetaData();
      seans.clear();
      seans.add("default");
      for (int i = 3; i <= 16; i++) {
        if (result.getString(i) == null)
          seans.add(rsmd.getColumnName(i));
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return seans;
  }

}
