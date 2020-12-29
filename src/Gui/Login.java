package Gui;

import User.*;
import Connection.*;
import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

  public boolean isSucsesful = false;
  private String sifre;
  private String adSoyad;
  private String tcKimlikNo;
  private Jdbc db = null;

  private javax.swing.JPasswordField sifre_alani;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JTextField kimlik_alani;
  private javax.swing.JButton login;
  private javax.swing.JButton register;

  public Login(Jdbc db) {
    this.db = db;
    initComponents();
    this.setVisible(true);
  }

  private void initComponents() {
    jPanel1 = new javax.swing.JPanel();
    kimlik_alani = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    sifre_alani = new javax.swing.JPasswordField();
    jPanel2 = new javax.swing.JPanel();
    register = new javax.swing.JButton();
    login = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(153, 255, 255));

    kimlik_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("Şifre :");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("TC Kimlik No:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
            jPanel1Layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(sifre_alani))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(kimlik_alani,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(204, 204, 204)));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addGap(76, 76, 76)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(kimlik_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addComponent(sifre_alani))
            .addContainerGap(128, Short.MAX_VALUE)));

    jPanel2.setBackground(new java.awt.Color(102, 255, 255));

    register.setBackground(new java.awt.Color(255, 102, 102));
    register.setForeground(new java.awt.Color(51, 51, 255));
    register.setText("Kayit Ol");
    register.addActionListener(this);

    login.setBackground(new java.awt.Color(255, 102, 102));
    login.setForeground(new java.awt.Color(51, 51, 255));
    login.setText("Giriş Yap");
    login.addActionListener(this);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup().addGap(94, 94, 94)
            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(37, 37, 37)
            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(152, Short.MAX_VALUE)));
    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup().addGap(68, 68, 68)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(157, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
            Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel2,
                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)));

    pack();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == login) {
      this.sifre = String.valueOf(sifre_alani.getPassword());
      this.tcKimlikNo = kimlik_alani.getText();
      try {
        ResultSet result = db.executeQuery("select * from  hastane.hastalar where tc = " + this.tcKimlikNo + " ;");
        if (!result.next())
          JOptionPane.showMessageDialog(this, "Hiçbir kullanıcı bulunmamaktadır...");
        else {
          if (result.getString(3).equals(this.sifre)) {
            new AnaSayfa(this.db);
            this.dispose();
            isSucsesful = true;
          } else {
            JOptionPane.showMessageDialog(this, "Hatalı şifre !!!");
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    if (e.getSource() == register) {
      new Register(this.db);
    }

  }

}
