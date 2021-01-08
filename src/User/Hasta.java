package User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import Connection.Jdbc;

public class Hasta implements User {

  protected String isim = null;
  protected String tc = null;
  protected String sifre = null;
  protected Jdbc db;

  private String selectedpol_id = null;
  private String selectedpol = null;
  private String selecteddok_id = null;
  private String selecteddok = null;
  private String selectedtarih = null;
  private String selectedseans = null;

  public Hasta(String tc, String sifre, Jdbc db) {
    this.tc = tc;
    this.sifre = sifre;
    this.db = db;
    try {
      ResultSet result = db.executeQuery("select isim from  hastane.hastalar where tc = " + tc + " ;");
      result.next();
      this.isim = result.getString(1).toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getSelectedTarih() {
    return this.selectedtarih;
  }

  public String getTc() {
    return this.tc;
  }

  public String getName() {
    return this.isim;
  }

  public void setSelectedDok(String selecteddok) {
    this.selecteddok = selecteddok;
  }

  public void setSelectedPol(String selectedpol) {
    this.selectedpol = selectedpol;
  }

  public void selectedseans(String selectedseans) {
    this.selectedseans = selectedseans;
  }

  public void setSelectedtarih(String selectedtarih) {
    this.selectedtarih = selectedtarih;
  }

  public String getPolId(String polName) {
    try {
      ResultSet res = this.db.executeQuery("select pol_id FROM hastane.poliklinik where pol_name = '" + polName + "';");
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getDokId(String dokName, String PolId) {
    try {
      ResultSet res = this.db.executeQuery("select dok_id FROM hastane.doktorlar where dok_name = '" + dokName
          + "' AND  dok_pol_id = '" + PolId + "' ;");
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
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

  public Vector<String> getDoktroList() {
    Vector<String> dok = new Vector<String>();
    try {
      ResultSet result = this.db
          .executeQuery("select pol_id FROM hastane.poliklinik where pol_name = '" + this.selectedpol + "';");
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

  public Vector<String> getseans() {
    Vector<String> seans = new Vector<String>();
    if (selecteddok != null) {
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
    }
    return seans;
  }

  public void setRandevu() {
    try {
      this.db.executeUpdate("UPDATE hastane.hafta SET " + this.selectedseans + " = " + this.tc + " Where h_dok_id = "
          + this.selecteddok_id + " and gun = '" + this.selectedtarih + "';");
      JOptionPane.showMessageDialog(null, "Randevu başarılı şekilde alındı.");

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Randevu alma işllemi gerçekleştirilemedi.");
    }

    this.selectedpol_id = null;
    this.selectedpol = null;
    this.selecteddok_id = null;
    this.selecteddok = null;
    this.selectedtarih = null;
    this.selectedseans = null;

  }

  public ArrayList<String[]> getRandList() {
    ArrayList<String[]> ret = new ArrayList<String[]>();

    try {
      ResultSet result = this.db
          .executeQuery("select * from hastane.hafta where s9 = " + this.tc + "  or s9_30 = " + this.tc + " or s10 = "
              + this.tc + " or s10_30 = " + this.tc + " or s11 = " + this.tc + " or s11_30 = " + this.tc + " or s13 = "
              + this.tc + " or s13_30 = " + this.tc + " or s14 = " + this.tc + " or s14_30 = " + this.tc + "  or s15 = "
              + this.tc + " or s15_30 = " + this.tc + " or s16 = " + this.tc + " or s16_30 = " + this.tc + ";");
      ResultSetMetaData rsmd = result.getMetaData();
      while (result.next()) {
        String[] row = new String[4];
        row[0] = result.getString(2);
        for (int i = 3; i <= 16; i++) {
          if (result.getString(i) != null) {
            if (result.getString(i).equals(this.tc)) {
              row[1] = rsmd.getColumnName(i);
              break;
            }
          }
        }
        row[2] = result.getString(1);
        row[3] = result.getString(1);
        ret.add(row);
      }

      for (String[] strings : ret) {
        result = this.db.executeQuery(
            "SELECT pol_name FROM hastane.poliklinik WHERE pol_id in(SELECT dok_pol_id FROM hastane.doktorlar WHERE dok_id = '"
                + strings[2] + "' );");
        result.next();
        strings[2] = result.getString(1);// dok_id değerinden poliklink adına

      }
      for (String[] strings : ret) {
        result = this.db.executeQuery("SELECT dok_name FROM hastane.doktorlar WHERE dok_id = '" + strings[3] + "';");
        result.next();
        strings[3] = result.getString(1);// dok_id değerinden dok_name değerine

      }

      return ret;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void randevuSil(String tarih, String saat, String pol, String dok) {

    this.selectedpol = pol;
    this.selecteddok = dok;

    this.selectedpol_id = getPolId(selectedpol);
    this.selecteddok_id = getDokId(this.selecteddok, this.selectedpol_id);

    try {
      this.db.executeUpdate("UPDATE hastane.hafta SET " + saat + " = null Where h_dok_id = " + this.selecteddok_id
          + " and gun = '" + tarih + "';");
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.selectedpol_id = null;
    this.selectedpol = null;
    this.selecteddok_id = null;
    this.selecteddok = null;
  }

}
