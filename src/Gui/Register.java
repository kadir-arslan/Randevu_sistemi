package Gui;

import Connection.*;
import java.awt.event.*;
import javax.swing.*;

public class Register extends JFrame implements ActionListener {

        private Jdbc db = null;

        private javax.swing.JTextField isim_alani;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField kimlik_alani;
        private javax.swing.JButton register;
        private javax.swing.JPasswordField sifre_alani;

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
                jLabel3 = new javax.swing.JLabel();
                sifre_alani = new javax.swing.JPasswordField();
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(204, 255, 255));
                jPanel1.setPreferredSize(new java.awt.Dimension(800, 550));

                isim_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                kimlik_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                register.setIcon(new javax.swing.ImageIcon("C:\\Users\\excalibur\\Downloads\\id.png")); // NOI18N
                register.setText("Kayıt Ol");
                register.addActionListener(this);

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setText("Ad Soyad:");

                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setText("TC Kimlik No:");

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setText("Şifre :");

                sifre_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(161, 161, 161)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                150, Short.MAX_VALUE))
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                232, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(sifre_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                300,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(kimlik_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                300,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(isim_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                300,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(95, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(297, 297, 297)
                                                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(75, 75, 75)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(isim_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(kimlik_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(sifre_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(100, 100, 100)
                                                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(181, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                pack();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == register) {
                        try {

                                db.executeUpdate("INSERT INTO hastane.hastalar VALUES(" + kimlik_alani.getText() + ",'"
                                                + isim_alani.getText() + "','"
                                                + String.valueOf(sifre_alani.getPassword()) + "');");
                                JOptionPane.showMessageDialog(this,
                                                "Başarılı şekilde kayıt işlemi gerçekleştirildi !!!");
                                this.dispose();
                        } catch (Exception ex) {
                                // yanlış girdiler için düzenlenmes gerek
                                ex.printStackTrace();
                        }
                }
        }

}
