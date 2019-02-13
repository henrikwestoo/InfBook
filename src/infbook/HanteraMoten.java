/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public HanteraMoten(Connection connection, String status, String angivetAnv) {
        initComponents();
        this.connection = connection;
        this.status = status;
        this.angivetAnv = angivetAnv;
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSkapaMote = new javax.swing.JButton();
        btnRedMote = new javax.swing.JButton();
        btnTaBortMote = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSkapaMote.setText("Skapa möten");
        btnSkapaMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaMoteActionPerformed(evt);
            }
        });

        btnRedMote.setText("Redigera möten");
        btnRedMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedMoteActionPerformed(evt);
            }
        });

        btnTaBortMote.setText("Ta bort möten");
        btnTaBortMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortMoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRedMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSkapaMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaBortMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSkapaMote)
                .addGap(49, 49, 49)
                .addComponent(btnRedMote)
                .addGap(54, 54, 54)
                .addComponent(btnTaBortMote)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaMoteActionPerformed
        
     new SkapaMoten(connection, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnSkapaMoteActionPerformed

    private void btnTaBortMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortMoteActionPerformed
        new TaBortMoten(connection, status, angivetAnv).setVisible(true); 
    }//GEN-LAST:event_btnTaBortMoteActionPerformed

    private void btnRedMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedMoteActionPerformed
new RedigeraMoten(connection, status, angivetAnv).setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedMoteActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRedMote;
    private javax.swing.JButton btnSkapaMote;
    private javax.swing.JButton btnTaBortMote;
    // End of variables declaration//GEN-END:variables
}
