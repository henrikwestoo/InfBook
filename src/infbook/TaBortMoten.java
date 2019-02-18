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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
public class TaBortMoten extends javax.swing.JFrame {

    private Connection connection;
    private DefaultListModel lista;
    private String status;
    private String angivetAnv;
    private String inlaggsID;

    public TaBortMoten(Connection connection, String status, String angivetAnv) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.status = status;
        this.angivetAnv = angivetAnv;

        lista = new DefaultListModel();
        fyllComboxTaBortMoten();
        

    }

    private void fyllComboxTaBortMoten() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs2 = stmt.executeQuery("SELECT MOTESID, INFO, SAL FROM MOTE");

            while (rs2.next()) {

                lista.addElement(rs2.getString("MOTESID") + " " + rs2.getString("INFO") + " " + rs2.getString("SAL"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaMoten.setModel(lista);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();
        jPanel2 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMoten = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        btnTaBortBekrafta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnRefresh.setText("↻");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaMoten);

        jLabel1.setText("Ta bort möten");

        btnTaBortBekrafta.setText("Ta bort");
        btnTaBortBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortBekraftaActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbook.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTaBortBekrafta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefresh))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnTaBortBekrafta))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        lista.removeAllElements();
        fyllComboxTaBortMoten();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTaBortBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortBekraftaActionPerformed
        String valtInlagg = (String) listaMoten.getSelectedValue();
            inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));

            btnTaBortBekrafta.setVisible(true);
            
        String KID = ""; //Angivet kommentarID, det man vill ta bort

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ANVANDARE FROM MOTE WHERE MOTESID =" + inlaggsID); //Hittar vem som kommenterat

            rs.next();

            String kommenterareID = rs.getString("ANVANDARE"); //Variabel för den som kommenterat, IDt

            String posterStatus = getAnvandarStatus(inlaggsID);

            boolean FAbehorighet = false; //En boolean som kontrollerar om du har behörighet att ta bort en kommentar som forskningsadministratör

            if (status.equals("FA") && posterStatus.equals("F") || status.equals("FA") && posterStatus.equals("FA")) {

                FAbehorighet = true;

            }

            boolean UAbehorighet = false; //En boolean som kontrollerar om du har behörighet att ta bort en kommentar som utbildningsadministratör

            if (status.equals("UA") && posterStatus.equals("U") || status.equals("UA") && posterStatus.equals("UA")) {

                UAbehorighet = true;
            }

            if (kommenterareID.equals(angivetAnv) || status.equals("CA") || FAbehorighet || UAbehorighet) { //Om den som kommenterat är samma som den som är inloggad

                Statement stmt1 = connection.createStatement();
                stmt1.executeUpdate("DELETE FROM MOTE_ANVANDARE2 WHERE MOTE =" + inlaggsID);
                stmt1.executeUpdate("DELETE FROM MOTE WHERE MOTESID =" + inlaggsID);

            } else {

                JOptionPane.showMessageDialog(null, "Du har inte behörighet att ta bort mötet");

            }
            JOptionPane.showMessageDialog(null, "Mötet har tagits bort");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }//GEN-LAST:event_btnTaBortBekraftaActionPerformed
    public String getAnvandarStatus(String inlaggsID) { //Används för att kolla statusen på personen som gjort inlägget, returnerar statusen

        String status = "";

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT STATUS FROM MOTE JOIN ANVANDARE ON MOTE.ANVANDARE = ANVANDARE.PNR WHERE MOTESID =" + inlaggsID);
            rs.next();

            status = rs.getString("STATUS"); //

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel i databasen");
        }

        return status;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTaBortBekrafta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaMoten;
    // End of variables declaration//GEN-END:variables
}
