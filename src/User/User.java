package User;

import java.util.ArrayList;
import java.util.Vector;

import Connection.Jdbc;

public interface User {
  public String getSelectedTarih();

  public String getName();

  public String getTc();

  public String getPolId(String polName);

  public String getDokId(String dokName, String PolId);

  public void setSelectedDok(String selecteddok);

  public void setSelectedPol(String selectedpol);

  public void selectedseans(String selectedseans);

  public void setSelectedtarih(String selectedtarih);

  public Vector<String> getPoliklinikList();

  public Vector<String> getDoktroList();

  public Vector<String> getseans();

  public void setRandevu();

  public ArrayList<String[]> getRandList();

  public void deleteRandevu(String tarih, String saat, String pol, String dok);

  public String getSifre();
}
