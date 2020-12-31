package User;

import Connection.Jdbc;
import java.util.Vector;

public interface User {
  public String getSelectedTarih();

  public String getName();

  public String getTc();

  public void setSelectedDok(String selecteddok);

  public void selectedpol(String selectedpol);

  public void selectedseans(String selectedseans);

  public void setSelectedtarih(String selectedtarih);

  public Vector<String> getPoliklinikList();

  public Vector<String> getDoktroList();

  public Vector<String> getseans();

  public void setRandevu();
}
