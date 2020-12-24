package User;

public interface User {

  public void getPoliklinikList();

  public void getDoktroList(int pol_id);

  public void getProgramList(int dok_id);

  public void getseans(int dok_id, String saat);

}
