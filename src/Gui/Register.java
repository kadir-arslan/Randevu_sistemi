package Gui;

import Connection.*;
import java.awt.event.*;
import javax.swing.*;

public class Register extends JFrame implements ActionListener {

  private Jdbc db = null;

  private javax.swing.JTextField isim_alani;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField kimlik_alani;
  private javax.swing.JButton register;

  public Register(Jdbc db) {

    this.db = db;
    initComponents();
    this.setVisible(true);

  }

  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    isim_alani = new javax.swing.JTextField();
    kimlik_alani = new javax.swing.JTextField();
    register = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(204, 255, 255));

    register.setText("Kayıt Ol");
    register.addActionListener(this);

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("Ad Soyad:");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("TC Kimlik No:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(187, 187, 187)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                            jPanel1Layout.createSequentialGroup().addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(isim_alani)
                        .addComponent(kimlik_alani, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(244, 244, 244).addComponent(register,
                    javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(196, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addGap(75, 75, 75)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(isim_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(25, 25, 25)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(kimlik_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                    javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(57, 57, 57)
            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(250, Short.MAX_VALUE)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
        jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

    pack();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == register) {
      try {
        db.executeUpdate("INSERT INTO hastane.hastalar VALUES(" + kimlik_alani.getText() + ",'" + isim_alani.getText()
            + "','1234');");
        JOptionPane.showMessageDialog(this, "Başarılı şekilde kayıt işlemi gerçekleştirildi !!!");
        this.dispose();
      } catch (Exception ex) {
        // yanlış girdiler için düzenlenmes gerek
        ex.printStackTrace();
      }
    }
  }

}
