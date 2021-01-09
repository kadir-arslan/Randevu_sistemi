package Gui;

import User.*;
import java.util.*;

import java.awt.event.*;
import javax.swing.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class YeniRand extends JFrame implements ActionListener {

        public User user;

        private Vector<String> pol = new Vector<String>();
        private Vector<String> dok = new Vector<String>();
        private Vector<String> seans = new Vector<String>();

        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private com.toedter.calendar.JDateChooser jDateChooser1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private keeptoo.KButton kButton1;
        private keeptoo.KGradientPanel kGradientPanel1;

        public YeniRand(User user) {

                this.user = user;

                pol = user.getPoliklinikList();
                initComponents();
                this.setVisible(true);
        }

        private void initComponents() {

                kGradientPanel1 = new keeptoo.KGradientPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jComboBox3 = new javax.swing.JComboBox<>();
                jDateChooser1 = new com.toedter.calendar.JDateChooser();
                jComboBox2 = new javax.swing.JComboBox<>();
                jComboBox1 = new javax.swing.JComboBox<>();
                kButton1 = new keeptoo.KButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setResizable(false);

                kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
                kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 0));

                jLabel1.setBackground(new java.awt.Color(0, 153, 153));
                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText(" Randevu almak istediğiniz bölüm : ");

                jLabel2.setBackground(new java.awt.Color(0, 153, 153));
                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setText(" Doktorunuzu seçiiniz :");

                jLabel3.setBackground(new java.awt.Color(0, 153, 153));
                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText(" Tarih seçiniz :");

                jLabel4.setBackground(new java.awt.Color(0, 153, 153));
                jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                jLabel4.setText("Saat seçiniz :");

                jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                jDateChooser1.setMaxSelectableDate(new java.util.Date(1640984400000L));
                jDateChooser1.setMinSelectableDate(java.util.Calendar.getInstance().getTime());

                jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(pol));
                jComboBox1.addItemListener((ItemEvent e) -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                if (jComboBox1.getSelectedItem().toString().equals("defualt")) {
                                        dok.clear();
                                        seans.clear();
                                        user.setSelectedPol(null);
                                        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(pol));
                                        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(dok));
                                        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(seans));
                                } else {
                                        user.setSelectedPol(jComboBox1.getSelectedItem().toString());
                                        dok = user.getDoktroList();
                                }
                                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(dok));
                        }
                });
                jComboBox2.addItemListener(e -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                user.setSelectedDok(jComboBox2.getSelectedItem().toString());

                                if (user.getSelectedTarih() != null) {
                                        seans = user.getseans();
                                        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(seans));
                                }
                        }
                });
                jDateChooser1.addPropertyChangeListener(e -> {
                        if ("date".equals(e.getPropertyName())) {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                user.setSelectedtarih(dateFormat.format(jDateChooser1.getDate()));
                                Date date = (Date) e.getNewValue();
                                if (date.getDay() == 0) {
                                        JOptionPane.showMessageDialog(this, "Pazar gününe randevu alınamaz .");
                                } else {
                                        seans = user.getseans();
                                        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(seans));
                                }
                        }
                });

                jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jComboBox3.addItemListener(e -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                user.selectedseans(jComboBox3.getSelectedItem().toString());
                        }
                });

                // kButton1.setIcon(new
                // javax.swing.ImageIcon(getClass().getResource("/proje/icon/calendar.png")));
                // // NOI18N
                kButton1.setText("RANDEVUYU OLUŞTUR");
                kButton1.setkEndColor(new java.awt.Color(102, 255, 255));
                kButton1.setkHoverEndColor(new java.awt.Color(204, 204, 204));
                kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
                kButton1.setkHoverStartColor(new java.awt.Color(255, 102, 102));
                kButton1.addActionListener(this);

                javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
                kGradientPanel1.setLayout(kGradientPanel1Layout);
                kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGroup(kGradientPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                                                .addGap(20, 20, 20)
                                                                                .addGroup(kGradientPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                kGradientPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(kGradientPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                .addComponent(jLabel3,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                136,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jLabel2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                198,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jLabel4,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                122,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGap(51, 51, 51))
                                                                                                .addGroup(kGradientPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addGap(61, 61, 61)))
                                                                                .addGroup(kGradientPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(jComboBox1,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jComboBox2,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jDateChooser1,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                350,
                                                                                                                Short.MAX_VALUE)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                kGradientPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(42, 42, 42)
                                                                                                .addComponent(jComboBox3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                350,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                                .addGap(278, 278, 278).addComponent(kButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                249,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(81, Short.MAX_VALUE)));
                kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(39, 39, 39)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jComboBox1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jComboBox2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(43, 43, 43)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jDateChooser1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jComboBox3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54,
                                                                Short.MAX_VALUE)
                                                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)));

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

        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == kButton1) {
                        user.setRandevu();

                        this.dispose();

                }

        }
}
