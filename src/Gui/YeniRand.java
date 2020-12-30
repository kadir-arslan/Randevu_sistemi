package Gui;

import java.util.*;
import Connection.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class YeniRand extends JFrame implements ActionListener {

        private String tc;
        private String selectedpol_id;
        private Jdbc db;
        private String selectedpol;
        private String selecteddok_id;
        private String selecteddok;
        private String selectedtarih;
        private String selectedseans;
        private Vector<String> pol = new Vector<String>();
        private Vector<String> dok = new Vector<String>();
        private Vector<String> seans = new Vector<String>();
        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private com.toedter.calendar.JDateChooser jDateChooser1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;

        public YeniRand(Jdbc db, String tc) {

                this.db = db;
                this.tc = tc;

                try {
                        ResultSet result = this.db.executeQuery("SELECT * FROM hastane.poliklinik;");
                        pol.add("defualt");
                        while (result.next()) {
                                pol.add(result.getString(2));
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }

                initComponents();
                this.setVisible(true);
        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jLabel1 = new javax.swing.JLabel();
                jComboBox2 = new javax.swing.JComboBox<>();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jDateChooser1 = new com.toedter.calendar.JDateChooser();
                jComboBox3 = new javax.swing.JComboBox<>();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(204, 255, 255));
                // jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
                // public void componentResized(java.awt.event.ComponentEvent evt) {
                // jPanel1.ComponentResized(evt);
                // }
                // });

                jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(pol));

                jComboBox1.addItemListener((ItemEvent e) -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                selectedpol = jComboBox1.getSelectedItem().toString();
                                try {
                                        ResultSet result = this.db.executeQuery(
                                                        "select pol_id FROM hastane.poliklinik where pol_name = '"
                                                                        + jComboBox1.getSelectedItem().toString()
                                                                        + "';");
                                        if (result.next()) {
                                                selectedpol_id = result.getString(1);
                                        }
                                        ResultSet result2 = this.db.executeQuery(
                                                        "SELECT * FROM hastane.doktorlar WHERE dok_pol_id = '"
                                                                        + selectedpol_id + "';");
                                        dok.clear();
                                        dok.add("defualt");
                                        while (result2.next()) {
                                                dok.add(result2.getString(2));
                                        }

                                } catch (SQLException ex) {
                                        ex.printStackTrace();
                                }
                                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(dok));

                        }
                });
                jLabel1.setBackground(new java.awt.Color(0, 153, 153));
                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 0, 51));
                jLabel1.setText(" Randevu almak istediğiniz bölüm : ");

                jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jComboBox2.addItemListener(e -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                selecteddok = jComboBox2.getSelectedItem().toString();
                        }
                });

                jLabel2.setBackground(new java.awt.Color(0, 153, 153));
                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 0, 51));
                jLabel2.setText(" Doktorunuzu seçiiniz :");

                jLabel3.setBackground(new java.awt.Color(0, 153, 153));
                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 0, 51));
                jLabel3.setText(" Tarih seçiniz :");

                jLabel4.setBackground(new java.awt.Color(0, 153, 153));
                jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(255, 0, 51));
                jLabel4.setText(" Saat seçiniz:");

                jButton1.setBackground(new java.awt.Color(153, 153, 255));
                jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\excalibur\\Downloads\\appointment.png")); // NOI18N
                jButton1.setText("Randevuyu Oluştur");
                jButton1.addActionListener(this);

                jDateChooser1.setMaxSelectableDate(new java.util.Date(1640984400000L));
                jDateChooser1.setMinSelectableDate(java.util.Calendar.getInstance().getTime());
                jDateChooser1.addPropertyChangeListener(e -> {
                        if ("date".equals(e.getPropertyName())) {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                selectedtarih = dateFormat.format(jDateChooser1.getDate());
                                Date date = (Date) e.getNewValue();
                                if (date.getDay() == 0) {
                                        JOptionPane.showMessageDialog(this, "Pazar gününe randevu alınamaz .");
                                } else {
                                        try {
                                                ResultSet result = this.db.executeQuery(
                                                                "select dok_id From hastane.doktorlar where dok_name = '"
                                                                                + selecteddok + "' and dok_pol_id = '"
                                                                                + selectedpol_id + "'");
                                                if (result.next()) {
                                                        selecteddok_id = result.getString(1);
                                                }
                                                result = this.db.executeQuery("select * from hastane.hafta where gun ='"
                                                                + selectedtarih + "' and h_dok_id = '" + selecteddok_id
                                                                + "'");
                                                if (!result.next()) {
                                                        this.db.executeUpdate(
                                                                        "INSERT INTO hastane.hafta(h_dok_id,gun) values("
                                                                                        + selecteddok_id + ",'"
                                                                                        + selectedtarih + "');");
                                                        result = this.db.executeQuery(
                                                                        "select * from hastane.hafta where gun ='"
                                                                                        + selectedtarih
                                                                                        + "' and h_dok_id = '"
                                                                                        + selecteddok_id + "'");
                                                        result.next();
                                                }
                                                ResultSetMetaData rsmd = result.getMetaData();
                                                seans.clear();
                                                seans.add("default");
                                                for (int i = 3; i <= 16; i++) {
                                                        if (result.getString(i) == null)
                                                                seans.add(rsmd.getColumnName(i));
                                                }

                                        } catch (SQLException ex) {
                                                ex.printStackTrace();
                                        }
                                        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(seans));
                                }
                        }
                });

                jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jComboBox3.addItemListener(e -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                selectedseans = jComboBox3.getSelectedItem().toString();
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                315,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                214,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(106, 106,
                                                                                                                                106)))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                214,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(106, 106, 106))
                                                                                .addComponent(jLabel1))
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                350,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(jComboBox2,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jDateChooser1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                352,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jComboBox3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                350,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(269, 269, 269)
                                                                .addComponent(jButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                244,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(116, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(56, 56, 56)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jComboBox1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jComboBox2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jDateChooser1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jComboBox3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(62, 62, 62)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(93, Short.MAX_VALUE)));

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

        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {
                        try {
                                this.db.executeUpdate("UPDATE hastane.hafta SET " + selectedseans + " = " + tc
                                                + " Where h_dok_id = " + selecteddok_id + " and gun = '" + selectedtarih
                                                + "';");
                                JOptionPane.showMessageDialog(this, "Randevu başarılı şekilde alındı.");
                                this.dispose();

                        } catch (Exception ex) {
                                ex.printStackTrace();
                        }
                }

        }
}
