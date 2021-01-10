package Gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import User.*;

public class AdminSayfası extends JFrame {

        private User user;
        private Admin admin;

        private keeptoo.KButton doktor_ekle;
        private keeptoo.KButton doktor_sil;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTable jTable2;
        private javax.swing.JTable jTable3;
        private keeptoo.KGradientPanel kGradientPanel1;
        private keeptoo.KGradientPanel kGradientPanel2;
        private keeptoo.KGradientPanel kGradientPanel3;
        private keeptoo.KButton poliklinik_ekle;
        private keeptoo.KButton poliklinik_sil;
        private DefaultTableModel polModel;
        private DefaultTableModel dokModel;
        private DefaultTableModel randModel;

        public AdminSayfası(User user) {

                this.user = user;
                admin = new Admin(user.getTc(), user.getSifre(), user.getDb());

                initComponents();

                this.setVisible(true);
        }

        private void initComponents() {

                jTabbedPane1 = new javax.swing.JTabbedPane();
                kGradientPanel1 = new keeptoo.KGradientPanel();
                poliklinik_sil = new keeptoo.KButton();
                poliklinik_ekle = new keeptoo.KButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable();
                kGradientPanel2 = new keeptoo.KGradientPanel();
                doktor_sil = new keeptoo.KButton();
                doktor_ekle = new keeptoo.KButton();
                jScrollPane3 = new javax.swing.JScrollPane();
                jTable3 = new javax.swing.JTable();
                kGradientPanel3 = new keeptoo.KGradientPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
                kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 204));

                poliklinik_sil.setText("SİL");
                poliklinik_sil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                poliklinik_sil.setkBorderRadius(55);
                poliklinik_sil.setkEndColor(new java.awt.Color(204, 0, 153));
                poliklinik_sil.setkHoverEndColor(new java.awt.Color(204, 204, 204));
                poliklinik_sil.setkHoverForeGround(new java.awt.Color(0, 0, 0));
                poliklinik_sil.setkHoverStartColor(new java.awt.Color(204, 51, 0));
                poliklinik_sil.setBorder(null);
                poliklinik_sil.addActionListener(e -> {
                        int selectedRow = jTable2.getSelectedRow();
                        if (selectedRow == -1) {
                                // nop
                        } else {
                                admin.deletePol(polModel.getValueAt(selectedRow, 0).toString());
                        }
                        polModel.setRowCount(0);
                        ArrayList<String[]> polList;
                        polList = admin.getPolList();
                        for (String[] x : polList) {
                                polModel.addRow(x);
                        }
                });
                poliklinik_ekle.setText("EKLE");
                poliklinik_ekle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                poliklinik_ekle.setkBorderRadius(55);
                poliklinik_ekle.setkEndColor(new java.awt.Color(204, 0, 153));
                poliklinik_ekle.setkHoverEndColor(new java.awt.Color(204, 204, 204));
                poliklinik_ekle.setkHoverForeGround(new java.awt.Color(0, 0, 0));
                poliklinik_ekle.setkHoverStartColor(new java.awt.Color(204, 51, 0));
                poliklinik_ekle.setBorder(null);
                poliklinik_ekle.addActionListener(e -> {
                        String polName = JOptionPane.showInputDialog(this, "Poliklinik adı :", "Poliklinik Ekleme",
                                        JOptionPane.PLAIN_MESSAGE);
                        admin.addPol(polName);
                        polModel.setRowCount(0);
                        ArrayList<String[]> polList;
                        polList = admin.getPolList();
                        for (String[] x : polList) {
                                polModel.addRow(x);
                        }
                });
                jTable2.setAutoCreateRowSorter(true);
                jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null } },
                                new String[] { "Poliklinik ID", "Poliklinik Adı" }) {
                        boolean[] canEdit = new boolean[] { false, false };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jTable2.setSelectionBackground(new java.awt.Color(255, 204, 204));
                jScrollPane2.setViewportView(jTable2);
                if (jTable2.getColumnModel().getColumnCount() > 0) {
                        jTable2.getColumnModel().getColumn(0).setResizable(false);
                        jTable2.getColumnModel().getColumn(1).setResizable(false);
                }

                javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGroup(kGradientPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                                .addGap(35, 35, 35).addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                748,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                kGradientPanel1Layout.createSequentialGroup()
                                                                                .addGap(148, 148, 148)
                                                                                .addComponent(poliklinik_sil,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(107, 107, 107)
                                                                                .addComponent(poliklinik_ekle,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(62, Short.MAX_VALUE)));
                kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout
                                                .createSequentialGroup().addGap(29, 29, 29)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(poliklinik_sil,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(poliklinik_ekle,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(78, Short.MAX_VALUE)));

                jTabbedPane1.addTab("Poliklinik ", kGradientPanel1);

                kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
                kGradientPanel2.setkStartColor(new java.awt.Color(204, 255, 204));

                doktor_sil.setText("SİL");
                doktor_sil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                doktor_sil.setkBorderRadius(55);
                doktor_sil.setkEndColor(new java.awt.Color(204, 0, 153));
                doktor_sil.setkHoverEndColor(new java.awt.Color(204, 204, 204));
                doktor_sil.setkHoverForeGround(new java.awt.Color(0, 0, 0));
                doktor_sil.setkHoverStartColor(new java.awt.Color(204, 51, 0));
                doktor_sil.setBorder(null);
                doktor_sil.addActionListener(e -> {
                        int selectedRow = jTable3.getSelectedRow();
                        if (selectedRow == -1) {
                                // nop
                        } else {
                                admin.deleteDok(dokModel.getValueAt(selectedRow, 0).toString());
                        }
                        dokModel.setRowCount(0);
                        ArrayList<String[]> dokList;
                        dokList = admin.getDokList();
                        for (String[] x : dokList) {
                                dokModel.addRow(x);
                        }
                });
                doktor_ekle.setText("DOKTOR EKLE");
                doktor_ekle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                doktor_ekle.setkBorderRadius(55);
                doktor_ekle.setkEndColor(new java.awt.Color(204, 0, 153));
                doktor_ekle.setkHoverEndColor(new java.awt.Color(204, 204, 204));
                doktor_ekle.setkHoverForeGround(new java.awt.Color(0, 0, 0));
                doktor_ekle.setkHoverStartColor(new java.awt.Color(204, 51, 0));
                doktor_ekle.setBorder(null);
                doktor_ekle.addActionListener(e -> {
                        Object[] possibleValues = user.getPoliklinikList().toArray();
                        Object polName = JOptionPane.showInputDialog(this, "Poliklinik adı :", "Doktor Ekleme",
                                        JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);

                        String dokName = JOptionPane.showInputDialog(this, "Doktorun adı :", "Doktor Ekleme",
                                        JOptionPane.PLAIN_MESSAGE);
                        admin.addDok(dokName, polName.toString());
                        dokModel.setRowCount(0);
                        ArrayList<String[]> dokList;
                        dokList = admin.getDokList();
                        for (String[] x : dokList) {
                                dokModel.addRow(x);
                        }
                });
                jTable3.setAutoCreateRowSorter(true);
                jTable3.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null } },
                                new String[] { "Doktor ID", "Doktor Adı", "Poliklinik " }) {
                        boolean[] canEdit = new boolean[] { false, false, false };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jTable3.setSelectionBackground(new java.awt.Color(255, 204, 204));
                jScrollPane3.setViewportView(jTable3);
                if (jTable3.getColumnModel().getColumnCount() > 0) {
                        jTable3.getColumnModel().getColumn(0).setResizable(false);
                        jTable3.getColumnModel().getColumn(1).setResizable(false);
                        jTable3.getColumnModel().getColumn(2).setResizable(false);
                }

                javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
                kGradientPanel2.setLayout(kGradientPanel2Layout);
                kGradientPanel2Layout.setHorizontalGroup(kGradientPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout
                                                .createSequentialGroup().addContainerGap(51, Short.MAX_VALUE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 759,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35))
                                .addGroup(kGradientPanel2Layout.createSequentialGroup().addGap(166, 166, 166)
                                                .addComponent(doktor_sil, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(83, 83, 83)
                                                .addComponent(doktor_ekle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                kGradientPanel2Layout.setVerticalGroup(kGradientPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel2Layout.createSequentialGroup().addGap(76, 76, 76)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 141, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout
                                                .createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(kGradientPanel2Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(doktor_sil,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(doktor_ekle,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(47, 47, 47)));

                jTabbedPane1.addTab("Doktorlar", kGradientPanel2);

                kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
                kGradientPanel3.setkStartColor(new java.awt.Color(255, 153, 153));

                jTable1.setAutoCreateRowSorter(true);
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
                                                { null, null, null, null, null }, { null, null, null, null, null } },
                                new String[] { "TC Kimlik No:", "Tarih", "Saat", "Poliklinik", "Doktor" }) {
                        boolean[] canEdit = new boolean[] { false, false, false, false, false };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jTable1.setSelectionBackground(new java.awt.Color(255, 204, 204));
                jScrollPane1.setViewportView(jTable1);
                if (jTable1.getColumnModel().getColumnCount() > 0) {
                        jTable1.getColumnModel().getColumn(0).setResizable(false);
                        jTable1.getColumnModel().getColumn(1).setResizable(false);
                        jTable1.getColumnModel().getColumn(2).setResizable(false);
                        jTable1.getColumnModel().getColumn(3).setResizable(false);
                        jTable1.getColumnModel().getColumn(4).setResizable(false);
                }

                javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
                kGradientPanel3.setLayout(kGradientPanel3Layout);
                kGradientPanel3Layout.setHorizontalGroup(kGradientPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel3Layout.createSequentialGroup().addGap(22, 22, 22)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(44, Short.MAX_VALUE)));
                kGradientPanel3Layout.setVerticalGroup(kGradientPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel3Layout.createSequentialGroup().addGap(42, 42, 42)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(89, Short.MAX_VALUE)));

                jTabbedPane1.addTab("Randevular", kGradientPanel3);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTabbedPane1));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTabbedPane1));

                polModel = (DefaultTableModel) jTable2.getModel();
                dokModel = (DefaultTableModel) jTable3.getModel();
                randModel = (DefaultTableModel) jTable1.getModel();

                // randevu tablosunun popule edilmesi
                randModel.setRowCount(0);
                ArrayList<String[]> randList;
                randList = admin.getRandList();
                for (String[] x : randList) {
                        randModel.addRow(x);
                }
                // doktor tablosunun popule edilmesi
                dokModel.setRowCount(0);
                ArrayList<String[]> dokList;
                dokList = admin.getDokList();
                for (String[] x : dokList) {
                        dokModel.addRow(x);
                }
                // poliklinik tablosunun popule edilmesi
                polModel.setRowCount(0);
                ArrayList<String[]> polList;
                polList = admin.getPolList();
                for (String[] x : polList) {
                        polModel.addRow(x);
                }

                pack();
        }

}
