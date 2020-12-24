package Connection;

import java.sql.*;

public class Jdbc {
  final private String userName = "root";
  final private String password = "123456";
  final private String url = "jdbc:mysql://localhost:3306/?user=root";
  final private String Driver = "com.mysql.cj.jdbc.Driver";
  private String query;
  private Connection con = null;
  private Statement statement = null;

  public Jdbc() {
    try {
      this.connect();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void connect() throws SQLException {
    try {
      Class.forName(Driver);
    } catch (ClassNotFoundException e) {
      System.out.println("Error: unable to load driver class!");
    }

    this.con = DriverManager.getConnection(url, userName, password);
    this.statement = con.createStatement();
    System.out.println("baglandi");
  }

  public void icindeAra(String sr, String val) {
    // db de var olup olmadığını konturol eder ve bool döner
  }

  public ResultSet executeQuery(String query) throws SQLException {
    return this.statement.executeQuery(query);
  }

  public void executeUpdate(String update) throws SQLException {
    this.statement.executeUpdate(update);
  }

}
