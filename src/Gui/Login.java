package Gui;

import User.*;
import Connection.*;
import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

  private String sifre;
  private String tcKimlikNo;
  private Jdbc db = null;
  public User user;

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
    setPreferredSize(new java.awt.Dimension(800, 550));

    jPanel1.setBackground(new java.awt.Color(153, 255, 255));
    jPanel1.setPreferredSize(new java.awt.Dimension(800, 275));

    kimlik_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("Şifre :");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("TC Kimlik No:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
            jPanel1Layout.createSequentialGroup().addContainerGap(178, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sifre_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kimlik_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204)));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addGap(76, 76, 76)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(kimlik_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sifre_alani, javax.swing.GroupLayout.Alignment.TRAILING,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(71, 71, 71)));

    jPanel2.setBackground(new java.awt.Color(102, 102, 255));
    jPanel2.setPreferredSize(new java.awt.Dimension(669, 275));

    register.setBackground(new java.awt.Color(255, 102, 102));
    register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    register.setForeground(new java.awt.Color(51, 51, 255));
    register.setIcon(new javax.swing.ImageIcon("C:\\Users\\excalibur\\Downloads\\register.png")); // NOI18N
    register.setText("Kayit Ol");
    register.addActionListener(this);

    login.setBackground(new java.awt.Color(255, 102, 102));
    login.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    login.setForeground(new java.awt.Color(51, 51, 255));
    login.setIcon(new javax.swing.ImageIcon("C:\\Users\\excalibur\\Downloads\\user.png")); // NOI18N
    login.setText("Giriş Yap");
    login.addActionListener(this);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(37, 37, 37)
            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(120, 120, 120)));
    jPanel2Layout
        .setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup().addGap(104, 104, 104)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addComponent(jPanel1,
            javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
            javax.swing.GroupLayout.PREFERRED_SIZE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap()));

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
            user = new Hasta(this.tcKimlikNo, this.sifre, this.db);
            new AnaSayfa(this.user);
            this.dispose();

          } else {
            JOptionPane.showMessageDialog(this, "Hatalı şifre !!!");
          }
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }

    if (e.getSource() == register) {
      new Register(this.db);
    }

  }

}
