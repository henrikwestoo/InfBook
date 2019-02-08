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
    public HanteraMoten(Connection connection) {
        initComponents();
        this.connection = connection;
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
                .addComponent(btnSkapaMote)
                .addGap(18, 18, 18)
                .addComponent(btnRedMote)
                .addGap(21, 21, 21)
                .addComponent(btnTaBortMote)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSkapaMote)
                    .addComponent(btnRedMote)
                    .addComponent(btnTaBortMote))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaMoteActionPerformed
        
     new SkapaMoten(connection).setVisible(true);
    }//GEN-LAST:event_btnSkapaMoteActionPerformed

    private void btnTaBortMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortMoteActionPerformed
        new TaBortMoten(connection).setVisible(true); 
    }//GEN-LAST:event_btnTaBortMoteActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRedMote;
    private javax.swing.JButton btnSkapaMote;
    private javax.swing.JButton btnTaBortMote;
    // End of variables declaration//GEN-END:variables
}
