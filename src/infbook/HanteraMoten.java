/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class HanteraMoten extends javax.swing.JFrame {

    private Connection connection;
    private String status;
    private String angivetAnv;
    private String datumet;
    private String tiden;

    public HanteraMoten(Connection connection, String status, String angivetAnv) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.status = status;
        this.angivetAnv = angivetAnv;
        this.datumet = datumet;
        this.tiden = tiden;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnTaBortMote = new javax.swing.JButton();
        btnRedMote = new javax.swing.JButton();
        btnSkapaMote = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(46, 120, 186));

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookvit.png"))); // NOI18N
        lblPic.setMaximumSize(new java.awt.Dimension(200, 200));
        lblPic.setPreferredSize(new java.awt.Dimension(200, 210));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnTaBortMote.setText("Ta bort möten");
        btnTaBortMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortMoteActionPerformed(evt);
            }
        });

        btnRedMote.setText("Redigera möten");
        btnRedMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMoteActionPerformed(evt);
            }
        });

        btnSkapaMote.setText("Skapa möten");
        btnSkapaMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaMoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaBortMote, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(btnSkapaMote, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(btnRedMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnSkapaMote)
                .addGap(32, 32, 32)
                .addComponent(btnRedMote)
                .addGap(36, 36, 36)
                .addComponent(btnTaBortMote)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaMoteActionPerformed

        new SkapaMoten(connection, angivetAnv, datumet, tiden).setVisible(true);
    }//GEN-LAST:event_btnSkapaMoteActionPerformed

    private void btnTaBortMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortMoteActionPerformed
        new TaBortMoten(connection, status, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnTaBortMoteActionPerformed

    private void btnRedMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMoteActionPerformed
        new RedigeraMoten(connection, status, angivetAnv).setVisible(true);

    }//GEN-LAST:event_btnRedMoteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRedMote;
    private javax.swing.JButton btnSkapaMote;
    private javax.swing.JButton btnTaBortMote;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables
}
