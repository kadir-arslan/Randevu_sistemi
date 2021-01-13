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
  protected Selected selected = new Selected();

  public Hasta(String tc, String sifre) {
    this.tc = tc;
    this.sifre = sifre;
    try {
      ResultSet result = Jdbc.executeQuery("select isim from  hastane.hastalar where tc = " + tc + " ;");
      result.next();
      this.isim = result.getString(1).toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getSelectedTarih() {
    return this.selected.tarih;
  }

  @Override
  public String getTc() {
    return this.tc;
  }

  @Override
  public String getName() {
    return this.isim;
  }

  @Override
  public void setSelectedDok(String dok) {
    this.selected.dok = dok;
  }

  @Override
  public void setSelectedPol(String pol) {
    if (pol == null) {
      this.selected.clear();
    }
    this.selected.pol = pol;
  }

  @Override
  public void selectedseans(String seans) {
    this.selected.seans = seans;
  }

  @Override
  public void setSelectedtarih(String tarih) {
    this.selected.tarih = tarih;
  }

  @Override
  public String getPolId(String polName) {
    try {
      ResultSet res = Jdbc.executeQuery("select pol_id FROM hastane.poliklinik where pol_name = '" + polName + "';");
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String getDokId(String dokName, String PolId) {
    try {
      ResultSet res = Jdbc.executeQuery("select dok_id FROM hastane.doktorlar where dok_name = '" + dokName
          + "' AND  dok_pol_id = '" + PolId + "' ;");
      res.next();
      return res.getString(1);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Vector<String> getPoliklinikList() {
    Vector<String> pol = new Vector<String>();

    try {
      ResultSet result = Jdbc.executeQuery("SELECT * FROM hastane.poliklinik;");
      pol.add("defualt");
      while (result.next()) {
        pol.add(result.getString(2));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pol;
  }

  @Override
  public Vector<String> getDoktroList() {
    Vector<String> dok = new Vector<String>();
    try {
      ResultSet result = Jdbc
          .executeQuery("select pol_id FROM hastane.poliklinik where pol_name = '" + this.selected.pol + "';");
      if (result.next()) {
        this.selected.polId = result.getString(1);
      }
      ResultSet result2 = Jdbc
          .executeQuery("SELECT * FROM hastane.doktorlar WHERE dok_pol_id = '" + this.selected.polId + "';");
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

  @Override
  public Vector<String> getseans() {
    Vector<String> seans = new Vector<String>();
    if (this.selected.dok != null) {
      try {
        ResultSet result = Jdbc.executeQuery("select dok_id From hastane.doktorlar where dok_name = '"
            + this.selected.dok + "' and dok_pol_id = '" + this.selected.polId + "'");
        if (result.next()) {
          this.selected.dokId = result.getString(1);
        }
        result = Jdbc.executeQuery("select * from hastane.hafta where gun ='" + this.selected.tarih
            + "' and h_dok_id = '" + this.selected.dokId + "'");
        if (!result.next()) {
          Jdbc.executeUpdate("INSERT INTO hastane.hafta(h_dok_id,gun) values(" + this.selected.dokId + ",'"
              + this.selected.tarih + "');");
          result = Jdbc.executeQuery("select * from hastane.hafta where gun ='" + this.selected.tarih
              + "' and h_dok_id = '" + this.selected.dokId + "'");
          result.next();
        }
        ResultSetMetaData rsmd = result.getMetaData();
        seans.clear();
        seans.add("default");
        for (int i = 3; i <= 16; i++) {
          if (result.getString(i) == null)
            seans.add(rsmd.getColumnName(i).toString().substring(1, 3) + "."
                + rsmd.getColumnName(i).toString().substring(4, 6));
        }

      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    return seans;
  }

  @Override
  public void setRandevu() {
    try {
      ResultSet result = Jdbc.executeQuery("select * from hastane.hafta where h_dok_id =" + this.selected.dokId
          + " and gun = '" + this.selected.tarih + "';");
      if (result.next()) {
        for (int i = 3; i < 16; i++) {
          if (result.getString(i) != null) {
            if (result.getString(i).equals(this.tc)) {
              JOptionPane.showMessageDialog(null, "Aynı gün içerisinde birden fazla randevu alınamaz .");
              this.selected.clear();
            }
          }
        }
      }

      Jdbc.executeUpdate("UPDATE hastane.hafta SET " + this.selected.seans + " = " + this.tc + " Where h_dok_id = "
          + this.selected.dokId + " and gun = '" + this.selected.tarih + "';");
      JOptionPane.showMessageDialog(null, "Randevu başarılı şekilde alındı.");

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Randevu alma işlemi gerçekleştirilemedi.");
      this.selected.clear();
    }

  }

  @Override
  public ArrayList<String[]> getRandList() {
    ArrayList<String[]> ret = new ArrayList<String[]>();

    try {
      ResultSet result = Jdbc.executeQuery("select * from hastane.hafta where s09_00 = " + this.tc + "  or s09_30 = "
          + this.tc + " or s10_00 = " + this.tc + " or s10_30 = " + this.tc + " or s11_00 = " + this.tc
          + " or s11_30 = " + this.tc + " or s13_00 = " + this.tc + " or s13_30 = " + this.tc + " or s14_00 = "
          + this.tc + " or s14_30 = " + this.tc + "  or s15_00= " + this.tc + " or s15_30 = " + this.tc
          + " or s16_00 = " + this.tc + " or s16_30 = " + this.tc + ";");
      ResultSetMetaData rsmd = result.getMetaData();
      while (result.next()) {
        String[] row = new String[4];
        row[0] = result.getString(2);
        for (int i = 3; i <= 16; i++) {
          if (result.getString(i) != null) {
            if (result.getString(i).equals(this.tc)) {
              row[1] = rsmd.getColumnName(i).toString().substring(1, 3) + "."
                  + rsmd.getColumnName(i).toString().substring(4, 6);
              break;
            }
          }
        }
        row[2] = result.getString(1);
        row[3] = result.getString(1);
        ret.add(row);
      }

      for (String[] strings : ret) {
        result = Jdbc.executeQuery(
            "SELECT pol_name FROM hastane.poliklinik WHERE pol_id in(SELECT dok_pol_id FROM hastane.doktorlar WHERE dok_id = '"
                + strings[2] + "' );");
        result.next();
        strings[2] = result.getString(1);// dok_id değerinden poliklink adına

      }
      for (String[] strings : ret) {
        result = Jdbc.executeQuery("SELECT dok_name FROM hastane.doktorlar WHERE dok_id = '" + strings[3] + "';");
        result.next();
        strings[3] = result.getString(1);// dok_id değerinden dok_name değerine

      }

      return ret;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void deleteRandevu(String tarih, String saat, String pol, String dok) {

    this.selected.pol = pol;
    this.selected.dok = dok;

    this.selected.polId = getPolId(this.selected.pol);
    this.selected.dokId = getDokId(this.selected.dok, this.selected.polId);

    try {
      Jdbc.executeUpdate("UPDATE hastane.hafta SET " + "s" + saat.substring(0, 2) + "_" + saat.substring(3, 5)
          + " = null Where h_dok_id = " + this.selected.dokId + " and gun = '" + tarih + "';");
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.selected.clear();
  }

  @Override
  public String getSifre() {
    return this.sifre;
  }

}
