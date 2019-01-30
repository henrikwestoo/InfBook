/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbooktest;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrik
 */
public class SkapaKategori extends javax.swing.JFrame {

    private Connection connection;
    
    /**
     * Creates new form SkapaKategori
     */
    public SkapaKategori(Connection connection) {
        initComponents();
        this.connection = connection;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbSuperkategori = new javax.swing.JComboBox<>();
        lblKategorinTillhor = new javax.swing.JLabel();
        lblNyKategori = new javax.swing.JLabel();
        txtNyttNamn = new javax.swing.JTextField();
        btnSkapaKategori = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbSuperkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblKategorinTillhor.setText("Kategorin tillhör");

        lblNyKategori.setText("Ny kategori namn");

        btnSkapaKategori.setText("Skapa kategori");
        btnSkapaKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaKategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKategorinTillhor)
                    .addComponent(txtNyttNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSkapaKategori)
                    .addComponent(lblNyKategori)
                    .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblKategorinTillhor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNyKategori)
                .addGap(18, 18, 18)
                .addComponent(txtNyttNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSkapaKategori)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaKategoriActionPerformed
JOptionPane.showMessageDialog(null, "Kategorin har skapats");        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkapaKategoriActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSkapaKategori;
    private javax.swing.JComboBox<String> cmbSuperkategori;
    private javax.swing.JLabel lblKategorinTillhor;
    private javax.swing.JLabel lblNyKategori;
    private javax.swing.JTextField txtNyttNamn;
    // End of variables declaration//GEN-END:variables
}
