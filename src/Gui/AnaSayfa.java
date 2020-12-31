package Gui;

import User.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class AnaSayfa extends JFrame implements ActionListener {

        public User user;
        private javax.swing.JButton güncelle_butonu;
        private javax.swing.JTable hasta_tablosu;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JButton silme_butonu;
        private javax.swing.JButton yeni_randevu;
        private DefaultTableModel model;

        public AnaSayfa(User user) {
                this.user = user;

                initComponents();
                this.setVisible(true);
                model = (DefaultTableModel) hasta_tablosu.getModel();
                // populatin table
                model.setRowCount(0);
                ArrayList<String[]> randList;
                randList = user.getRandList();
                for (String[] x : randList) {
                        model.addRow(x);
                }

        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jTextField2 = new javax.swing.JTextField();
                jScrollPane1 = new javax.swing.JScrollPane();
                hasta_tablosu = new javax.swing.JTable();
                yeni_randevu = new javax.swing.JButton();
                silme_butonu = new javax.swing.JButton();
                güncelle_butonu = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setText("Ad Soyad :");

                jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jTextField1.setPreferredSize(new java.awt.Dimension(70, 70));
                jTextField1.setEditable(false);
                jTextField1.setText(user.getName());
                jTextField1.setBorder(null);

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setText("TC Kimlik No:");

                jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jTextField2.setPreferredSize(new java.awt.Dimension(70, 70));
                jTextField2.setEditable(false);
                jTextField2.setText(user.getTc());
                jTextField2.setBorder(null);

                hasta_tablosu.setModel(
                                new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null } },
                                                new String[] { "Tarih", "Saat", "Poliklinik", "Doktor" }) {
                                        boolean[] canEdit = new boolean[] { false, false, false, false };

                                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                return canEdit[columnIndex];
                                        }
                                });
                hasta_tablosu.setRowHeight(25);
                jScrollPane1.setViewportView(hasta_tablosu);
                if (hasta_tablosu.getColumnModel().getColumnCount() > 0) {
                        hasta_tablosu.getColumnModel().getColumn(0).setResizable(false);
                        hasta_tablosu.getColumnModel().getColumn(1).setResizable(false);
                        hasta_tablosu.getColumnModel().getColumn(2).setResizable(false);
                        hasta_tablosu.getColumnModel().getColumn(3).setResizable(false);
                }

                yeni_randevu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                yeni_randevu.setIcon(new javax.swing.ImageIcon(getClass().getResource(""))); // NOI18N
                yeni_randevu.setText("YENİ RANDEVU OLUŞTUR");
                yeni_randevu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                yeni_randevu.addActionListener(e -> {
                        new YeniRand(this.user);
                });

                silme_butonu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                silme_butonu.setIcon(new javax.swing.ImageIcon("")); // NOI18N
                silme_butonu.setText(" Sil");
                silme_butonu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                silme_butonu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                silme_butonu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                silme_butonu.setMargin(new java.awt.Insets(2, 5, 2, 5));
                silme_butonu.setMaximumSize(new java.awt.Dimension(10, 10));
                silme_butonu.setMinimumSize(new java.awt.Dimension(10, 10));
                silme_butonu.setPreferredSize(new java.awt.Dimension(10, 10));
                silme_butonu.addActionListener(e -> {
                });

                güncelle_butonu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                güncelle_butonu.setIcon(new javax.swing.ImageIcon("")); // NOI18N
                güncelle_butonu.setText("Güncelle");
                güncelle_butonu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                güncelle_butonu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                güncelle_butonu.addActionListener(e -> {
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                200,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(26, 26, 26))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel3,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(18, 18, 18)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                300,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                300,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                647,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(silme_butonu,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                138,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(güncelle_butonu,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                138,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(259, 259, 259)
                                                                .addComponent(yeni_randevu)))
                                                .addContainerGap(19, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(44, 44, 44)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                240,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(yeni_randevu,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                73,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(19, Short.MAX_VALUE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(silme_butonu,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                46,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(güncelle_butonu,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(187, 187, 187)))));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }

        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == yeni_randevu) {
                        new YeniRand(this.user);
                }
        }

}
