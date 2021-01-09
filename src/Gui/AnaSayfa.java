package Gui;

import User.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;

public class AnaSayfa extends JFrame {

        public User user;
        private javax.swing.JButton güncelle_butonu;
        private javax.swing.JTable hasta_tablosu;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private keeptoo.KButton kButton1;
        private keeptoo.KGradientPanel kGradientPanel1;
        private javax.swing.JButton silme_butonu;
        private DefaultTableModel model;

        public AnaSayfa(User user) {
                this.user = user;

                initComponents();
                model = (DefaultTableModel) hasta_tablosu.getModel();
                this.setVisible(true);

                model.setRowCount(0);
                ArrayList<String[]> randList;
                randList = user.getRandList();
                for (String[] x : randList) {
                        model.addRow(x);
                }

        }

        private void initComponents() {

                kGradientPanel1 = new keeptoo.KGradientPanel();
                silme_butonu = new javax.swing.JButton();
                güncelle_butonu = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jTextField2 = new javax.swing.JTextField();
                jScrollPane1 = new javax.swing.JScrollPane();
                hasta_tablosu = new javax.swing.JTable();
                kButton1 = new keeptoo.KButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);

                kGradientPanel1.setkEndColor(new java.awt.Color(255, 102, 153));
                kGradientPanel1.setkStartColor(new java.awt.Color(153, 0, 153));
                kGradientPanel1.setPreferredSize(new java.awt.Dimension(850, 550));

                silme_butonu.setBackground(new java.awt.Color(204, 204, 255));
                silme_butonu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                silme_butonu.setForeground(new java.awt.Color(102, 0, 102));
                silme_butonu.setIcon(new javax.swing.ImageIcon("Icons/remove.png")); // NOI18N
                silme_butonu.setText(" Sil");
                silme_butonu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                silme_butonu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                silme_butonu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                silme_butonu.setMargin(new java.awt.Insets(2, 5, 2, 5));
                silme_butonu.setMaximumSize(new java.awt.Dimension(10, 10));
                silme_butonu.setMinimumSize(new java.awt.Dimension(10, 10));
                silme_butonu.setPreferredSize(new java.awt.Dimension(10, 10));
                silme_butonu.addActionListener(e -> {
                        int selectedRow = hasta_tablosu.getSelectedRow();
                        if (selectedRow == -1) {

                        } else {
                                user.randevuSil(model.getValueAt(selectedRow, 0).toString(),
                                                model.getValueAt(selectedRow, 1).toString(),
                                                model.getValueAt(selectedRow, 2).toString(),
                                                model.getValueAt(selectedRow, 3).toString());
                        }
                        model.setRowCount(0);
                        ArrayList<String[]> randList;
                        randList = user.getRandList();
                        for (String[] x : randList) {
                                model.addRow(x);
                        }
                });

                güncelle_butonu.setBackground(new java.awt.Color(204, 204, 255));
                güncelle_butonu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                güncelle_butonu.setForeground(new java.awt.Color(102, 0, 102));
                güncelle_butonu.setIcon(new javax.swing.ImageIcon("Icons/arrows.png")); // NOI18N
                güncelle_butonu.setText("Güncelle");
                güncelle_butonu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                güncelle_butonu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                güncelle_butonu.addActionListener(e -> {
                        model.setRowCount(0);
                        ArrayList<String[]> randList;
                        randList = user.getRandList();
                        for (String[] x : randList) {
                                model.addRow(x);
                        }
                });

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setText("Ad Soyad :");

                jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jTextField1.setPreferredSize(new java.awt.Dimension(70, 70));
                jTextField1.setText(user.getName());
                jTextField1.setBorder(null);
                jTextField1.setEditable(false);
                jTextField1.setOpaque(false);

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setText("TC Kimlik No:");

                jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jTextField2.setPreferredSize(new java.awt.Dimension(70, 70));
                jTextField2.setText(user.getTc());
                jTextField2.setBorder(null);
                jTextField2.setEditable(false);
                jTextField2.setOpaque(false);

                hasta_tablosu.setModel(
                                new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null } },
                                                new String[] { "Tarih", "Saat", "Poliklinik", "Doktor" }) {
                                        boolean[] canEdit = new boolean[] { false, false, false, false };

                                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                return canEdit[columnIndex];
                                        }
                                });
                hasta_tablosu.setRowHeight(25);
                hasta_tablosu.setBorder(null);
                hasta_tablosu.setAutoCreateRowSorter(true);
                jScrollPane1.setViewportView(hasta_tablosu);
                if (hasta_tablosu.getColumnModel().getColumnCount() > 0) {
                        hasta_tablosu.getColumnModel().getColumn(0).setResizable(false);
                        hasta_tablosu.getColumnModel().getColumn(1).setResizable(false);
                        hasta_tablosu.getColumnModel().getColumn(2).setResizable(false);
                        hasta_tablosu.getColumnModel().getColumn(3).setResizable(false);
                }
                kButton1.setIcon(new javax.swing.ImageIcon("Icons/plus_1.png")); // NOI18N
                kButton1.setText(" YENİ RANDEVU OLUŞTUR");
                kButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                kButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                kButton1.setkBackGroundColor(new java.awt.Color(51, 51, 255));
                kButton1.setkBorderRadius(30);
                kButton1.setkEndColor(new java.awt.Color(204, 204, 255));
                kButton1.setkHoverEndColor(new java.awt.Color(153, 153, 153));
                kButton1.setkHoverForeGround(new java.awt.Color(102, 0, 51));
                kButton1.setkHoverStartColor(new java.awt.Color(204, 255, 204));
                kButton1.setkPressedColor(new java.awt.Color(255, 0, 51));
                kButton1.setBorder(null);
                kButton1.addActionListener(e -> {
                        new YeniRand(this.user);
                });

                javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGroup(kGradientPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                                .addContainerGap().addComponent(jScrollPane1))
                                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(kGradientPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addGroup(kGradientPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(156, 156,
                                                                                                                                156)
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addGap(43, 43, 43)
                                                                                                                .addComponent(jTextField2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                300,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(kGradientPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                103,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(28, 28, 28)
                                                                                                                .addComponent(jTextField1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                300,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(kGradientPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(113, 113, 113)
                                                                                                .addComponent(silme_butonu,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                138,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(26, 26, 26)
                                                                                                .addComponent(kButton1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                285,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(26, 26, 26)
                                                                                                .addComponent(güncelle_butonu,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                138,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 112, Short.MAX_VALUE)))
                                                .addContainerGap()));
                kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(23, 23, 23)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
                                                                Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(kButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                74,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(güncelle_butonu,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(silme_butonu,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                pack();
        }

}
