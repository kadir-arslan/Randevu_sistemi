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

  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private keeptoo.KGradientPanel kGradientPanel1;
  private keeptoo.KGradientPanel kGradientPanel2;
  private javax.swing.JTextField kimlik_alani;
  private keeptoo.KButton login;
  private keeptoo.KButton register;
  private javax.swing.JPasswordField sifre_alani;
  private javax.swing.JCheckBox sifre_goster2;

  public Login(Jdbc db) {
    this.db = db;
    initComponents();
    this.setVisible(true);
  }

  private void initComponents() {

    kGradientPanel1 = new keeptoo.KGradientPanel();
    jLabel3 = new javax.swing.JLabel();
    kGradientPanel2 = new keeptoo.KGradientPanel();
    jLabel2 = new javax.swing.JLabel();
    kimlik_alani = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    sifre_alani = new javax.swing.JPasswordField();
    sifre_goster2 = new javax.swing.JCheckBox();
    login = new keeptoo.KButton();
    register = new keeptoo.KButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setMaximumSize(new java.awt.Dimension(1000, 600));
    setMinimumSize(new java.awt.Dimension(1000, 600));
    setResizable(false);

    kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 255));
    kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 153));

    jLabel3.setFont(new java.awt.Font("Cambria Math", 3, 48)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(102, 0, 102));
    jLabel3.setText("      HOŞGELDİNİZ");

    kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
    kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("TC Kimlik No:");

    kimlik_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    kimlik_alani.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 0, 153)));
    kimlik_alani.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        kimlik_alaniKeyPressed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("Şifre :");

    sifre_alani.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 0, 153)));

    sifre_goster2.setBackground(new java.awt.Color(255, 255, 255));
    sifre_goster2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
    sifre_goster2.setText("Şifreyi göster");
    sifre_goster2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(51, 51, 255)));
    sifre_goster2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sifre_goster2ActionPerformed(evt);
      }
    });

    login.setIcon(new javax.swing.ImageIcon("Icons/user.png")); // NOI18N
    login.setText("GİRİŞ YAP");
    login.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    login.setkBackGroundColor(new java.awt.Color(255, 153, 153));
    login.setkBorderRadius(30);
    login.setkEndColor(new java.awt.Color(204, 0, 51));
    login.setkHoverEndColor(new java.awt.Color(51, 51, 51));
    login.setkHoverForeGround(new java.awt.Color(102, 0, 102));
    login.setkHoverStartColor(new java.awt.Color(204, 204, 204));
    login.setkSelectedColor(new java.awt.Color(153, 255, 153));
    login.addActionListener(this);
    login.setBorder(null);

    register.setIcon(new javax.swing.ImageIcon("Icons/register.png"));
    // NOI18N
    register.setText("KAYIT OL");
    register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    register.setkBackGroundColor(new java.awt.Color(255, 153, 153));
    register.setkBorderRadius(30);
    register.setkEndColor(new java.awt.Color(204, 0, 51));
    register.setkHoverEndColor(new java.awt.Color(51, 51, 51));
    register.setkHoverForeGround(new java.awt.Color(102, 0, 102));
    register.setkHoverStartColor(new java.awt.Color(204, 204, 204));
    register.setkSelectedColor(new java.awt.Color(153, 255, 153));
    register.addActionListener(this);
    register.setBorder(null);

    javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
    kGradientPanel2.setLayout(kGradientPanel2Layout);
    kGradientPanel2Layout.setHorizontalGroup(kGradientPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(41, 41, 41)
            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(kGradientPanel2Layout.createSequentialGroup().addGap(124, 124, 124)
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addGap(18, 18, 18)
            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                    .addComponent(sifre_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40).addComponent(sifre_goster2))
                .addComponent(kimlik_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(94, Short.MAX_VALUE)));
    kGradientPanel2Layout
        .setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup().addGap(62, 62, 62)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kimlik_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(
                            jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel2Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(
                            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sifre_goster2)
                                .addComponent(sifre_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(kGradientPanel2Layout.createSequentialGroup().addGap(38, 38, 38).addComponent(jLabel1,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            Short.MAX_VALUE))
                    .addGap(50, 50, 50)));

    javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
    kGradientPanel1.setLayout(kGradientPanel1Layout);
    kGradientPanel1Layout
        .setHorizontalGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(216, 216, 216).addComponent(jLabel3,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(106, 106, 106).addComponent(
                        kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE)));
    kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(kGradientPanel1Layout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(114, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
        kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
        kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

    pack();
  }

  private void kimlik_alaniKeyPressed(java.awt.event.KeyEvent evt) {

    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {

      if (kimlik_alani.getText().length() < 11) {
        kimlik_alani.setEditable(true);
      } else {
        kimlik_alani.setEditable(false);
      }
    } else {
      if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
        kimlik_alani.setEditable(true);
      } else {
        kimlik_alani.setEditable(false);
      }
    }
  }

  private void sifre_goster2ActionPerformed(java.awt.event.ActionEvent evt) {

    if (sifre_goster2.isSelected()) {
      sifre_alani.setEchoChar((char) 0);
    } else {
      sifre_alani.setEchoChar('*');
    }

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
            if (this.tcKimlikNo.equals("11111111111")) {
              new AdminSayfası(this.user);
            }
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
