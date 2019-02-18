/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author meeraj
 */
public class SkapaSubkategori extends javax.swing.JFrame {

    private Connection connection;

    /**
     * Creates new form SkapaSubkategorier
     */
    public SkapaSubkategori(Connection connection) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        fyllComboBoxSuperkategori();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtfalt = new javax.swing.JTextField();
        lblKategoriNamn = new javax.swing.JLabel();
        cmbValjSupKat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblNotis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbook.png"))); // NOI18N

        jButton1.setText("Skapa subkategori");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtfalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfaltActionPerformed(evt);
            }
        });

        lblKategoriNamn.setText("Namn");

        cmbValjSupKat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbValjSupKatActionPerformed(evt);
            }
        });

        jLabel1.setText("Välj superkategori");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKategoriNamn)
                    .addComponent(txtfalt, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbValjSupKat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbValjSupKat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblKategoriNamn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtfalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbValjSupKatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbValjSupKatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbValjSupKatActionPerformed

    private void fyllComboBoxSuperkategori() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI");

            while (rs.next()) {

                cmbValjSupKat.addItem(rs.getString("SKNAMN"));
                //cmbSuperkategori.addItem("SKNAMN");

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void txtfaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfaltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfaltActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Validering.isTextFältTomt(txtfalt)) {
            String valdsuperkat = String.valueOf(cmbValjSupKat.getSelectedItem());
            String skapaSubkategori = txtfalt.getText();

            try {
                Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT SUPERKATEGORIID FROM SUPERKATEGORI WHERE SKNAMN ='" + valdsuperkat + "'");
                rs.next();

                int superkategoriid = rs.getInt("SUPERKATEGORIID");

                Statement stmtTal = connection.createStatement();

                stmtTal.execute("SELECT MAX (SUBKATEGORIID) FROM SUBKATEGORI");
                ResultSet rsTal = stmtTal.getResultSet();

                if (rsTal.next()) {
                    int hogstaVarde = rsTal.getInt(1);
                    int nyaVardet = hogstaVarde + 1;
                    System.out.println(hogstaVarde);

                    PreparedStatement ps = connection.prepareStatement("insert into SUBKATEGORI(SUBKATEGORIID,SKNAMN,SUPERKATEGORI) values(?,?,?)");
                    ps.setInt(1, nyaVardet);
                    ps.setString(2, skapaSubkategori);
                    ps.setInt(3, superkategoriid);
                    ps.executeUpdate();

                    // JOptionPane.showMessageDialog(null, "Kategorin har skapats!");
                    lblNotis.setText("Kategorin har skapats!");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbValjSupKat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblKategoriNamn;
    private javax.swing.JLabel lblNotis;
    private javax.swing.JTextField txtfalt;
    // End of variables declaration//GEN-END:variables

}
