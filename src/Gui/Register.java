package Gui;

import Connection.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Register extends JFrame implements ActionListener {

        private Jdbc db = null;

        private javax.swing.JTextField isim_alani;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private keeptoo.KGradientPanel kGradientPanel1;
        private javax.swing.JTextField kimlik_alani;
        private keeptoo.KButton register;
        private javax.swing.JPasswordField sifre_alani;
        private javax.swing.JCheckBox sifre_goster;

        public Register(Jdbc db) {

                this.db = db;
                initComponents();
                this.setVisible(true);

        }

        private void initComponents() {

                kGradientPanel1 = new keeptoo.KGradientPanel();
                jPanel1 = new javax.swing.JPanel();
                sifre_goster = new javax.swing.JCheckBox();
                isim_alani = new javax.swing.JTextField();
                kimlik_alani = new javax.swing.JTextField();
                sifre_alani = new javax.swing.JPasswordField();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                register = new keeptoo.KButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setPreferredSize(new java.awt.Dimension(600, 600));
                setResizable(false);

                kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 204));
                kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
                                new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255),
                                new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));

                sifre_goster.setBackground(new java.awt.Color(255, 255, 255));
                sifre_goster.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
                sifre_goster.setText("Şifreyi göster");
                sifre_goster.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                sifre_gosterActionPerformed(evt);
                        }
                });

                isim_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                isim_alani.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0,
                                new java.awt.Color(51, 102, 255)));

                kimlik_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                kimlik_alani.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0,
                                new java.awt.Color(51, 102, 255)));

                kimlik_alani.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                kimlik_alaniKeyPressed(evt);
                        }
                });

                sifre_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                sifre_alani.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0,
                                new java.awt.Color(51, 102, 255)));
                sifre_alani.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                sifre_alaniKeyPressed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setText("   Ad Soyad:");

                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setText("TC Kimlik No:");

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setText(" Şifre :");

                jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(0, 153, 51));
                jLabel4.setText("             KAYIT ALANI");
                jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5,
                                new java.awt.Color(153, 153, 255)));

                register.setForeground(new java.awt.Color(0, 0, 0));
                register.setIcon(new javax.swing.ImageIcon("Icons/register.png"));
                // NOI18N
                register.setText(" KAYIT OL");
                register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                register.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                register.setkBackGroundColor(new java.awt.Color(102, 102, 255));
                register.setkHoverForeGround(new java.awt.Color(0, 0, 204));
                register.setkHoverStartColor(new java.awt.Color(153, 153, 255));
                register.addActionListener(this);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(69, 69, 69)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 354,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(0, 37, Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(sifre_goster,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                119,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                118,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(kimlik_alani,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                300,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                111,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(isim_alani,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                300,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addContainerGap(
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                62,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(register,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(sifre_alani,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                300,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(kimlik_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(sifre_alani,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31).addComponent(sifre_goster).addGap(66, 66, 66)
                                                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(88, 88, 88)));

                javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(50, 50, 50)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(25, Short.MAX_VALUE)));
                kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(30, 30, 30)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(31, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }

        private void kimlik_alaniKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_kimlik_alaniKeyPressed

                if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
                        if (kimlik_alani.getText().length() == 11) {
                                register.setEnabled(true);
                        } else {
                                register.setEnabled(false);
                        }

                        if (kimlik_alani.getText().length() < 11) {
                                kimlik_alani.setEditable(true);
                        } else {
                                kimlik_alani.setEditable(false);
                        }
                } else {
                        if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
                                        || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                                kimlik_alani.setEditable(true);
                        } else {
                                kimlik_alani.setEditable(false);
                        }
                }

                // TODO add your handling code here:
        }

        private void sifre_gosterActionPerformed(java.awt.event.ActionEvent evt) {

                if (sifre_goster.isSelected()) {
                        sifre_alani.setEchoChar((char) 0);
                } else {
                        sifre_alani.setEchoChar('*');
                }
        }

        private void sifre_alaniKeyPressed(java.awt.event.KeyEvent evt) {

                if (sifre_alani.getPassword().length < 15) {
                        sifre_alani.setEditable(true);
                } else {
                        sifre_alani.setEditable(false);
                }
                if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
                                || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                        sifre_alani.setEditable(true);
                }

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
                        } catch (SQLIntegrityConstraintViolationException ex) {
                                JOptionPane.showMessageDialog(this, "Önceden kayıt yapılmış !");
                                this.dispose();
                        } catch (SQLException e1) {
                                e1.printStackTrace();
                        }
                }
        }

}
