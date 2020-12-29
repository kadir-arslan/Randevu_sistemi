package Gui;

import java.util.*;
import Connection.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class YeniRand extends JFrame implements ActionListener {

        private String pol_id;
        private Jdbc db;
        private javax.swing.JButton jButton1;
        private Vector<String> pol = new Vector<String>();
        private Vector<String> dok = new Vector<String>();
        private Vector<String> seans = new Vector<String>();
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;

        public YeniRand(Jdbc db) {

                this.db = db;

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

                jComboBox1 = new javax.swing.JComboBox<>();
                jComboBox2 = new javax.swing.JComboBox<>();
                jComboBox3 = new javax.swing.JComboBox<>();
                jButton1 = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();

                this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(pol));
                jComboBox1.addItemListener((ItemEvent e) -> {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                try {
                                        ResultSet result = this.db.executeQuery(
                                                        "select pol_id FROM hastane.poliklinik where pol_name = '"
                                                                        + jComboBox1.getSelectedItem().toString()
                                                                        + "';");
                                        if (result.next()) {
                                                pol_id = result.getString(1);
                                        }
                                        ResultSet result2 = this.db.executeQuery(
                                                        "SELECT * FROM hastane.doktorlar WHERE dok_pol_id = '" + pol_id
                                                                        + "';");
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
                // jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(dok));

                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                jButton1.setText("Randevuyu Oluştur");

                jLabel1.setText("Randevu almak istediğiniz bölüm : ");

                jLabel2.setText("Doktorunuz :");

                jLabel3.setText("Seans :");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(275, 275, 275)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                214, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jLabel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                214, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76,
                                                                Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jComboBox1,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                332,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jComboBox2,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                332,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jComboBox3,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                332,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(64, 64, 64)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(87, 87, 87).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 49,
                                                                Short.MAX_VALUE))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jComboBox2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                49, Short.MAX_VALUE))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jComboBox3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                49, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                141, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75)));

                pack();
        }

        public void actionPerformed(ActionEvent e) {

        }
}
