/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
public class RedigeraMoten extends javax.swing.JFrame {

    private String motesid;
    private Connection connection;
    private DefaultListModel lista;
    private String angivetAnv;
    private String inlaggsID;
    private String status;

    public RedigeraMoten(Connection connection, String status, String angivetAnv) {

        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.status = status;
        this.angivetAnv = angivetAnv;
        lista = new DefaultListModel();
        fyllComboBoxAnvandare();
        btnÄndraMoten.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNotis = new javax.swing.JLabel();
        btnValjMote = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMoten = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAndraInfo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAndraSal = new javax.swing.JTextField();
        txtAndraTid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        valjDatum = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        btnÄndraMoten = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnValjMote.setText("Välj möte");
        btnValjMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValjMoteActionPerformed(evt);
            }
        });

        listaMoten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaMotenKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaMoten);

        jLabel1.setText("Ange möten");

        txtAndraInfo.setColumns(20);
        txtAndraInfo.setRows(5);
        jScrollPane2.setViewportView(txtAndraInfo);

        jLabel3.setText("Ändra info");

        jLabel2.setText("Ändra sal");

        jLabel4.setText("Ändra tid");

        jLabel5.setText("Ändra datum");

        btnÄndraMoten.setText("Spara ändringar");
        btnÄndraMoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÄndraMotenActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbook.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(lblNotis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(btnValjMote, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 19, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnÄndraMoten)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valjDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtAndraTid)
                            .addComponent(txtAndraSal))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnValjMote))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAndraSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAndraTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valjDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnÄndraMoten)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fyllComboBoxAnvandare() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs2 = stmt.executeQuery("SELECT MOTESID, INFO, SAL, TID, DATUM FROM MOTE");

            while (rs2.next()) {

                lista.addElement(rs2.getString("MOTESID") + " " + rs2.getString("INFO") + " " + rs2.getString("SAL") + " " + rs2.getString("TID") + " " + rs2.getDate("DATUM"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaMoten.setModel(lista);

    }
    private void btnÄndraMotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraMotenActionPerformed
        if (Validering.isTextFältTomt(txtAndraSal) && Validering.isTextFältTomt(txtAndraTid) && Validering.isTextAreaTomt(txtAndraInfo) && Validering.isDateChooserTomt(valjDatum)) {
            try {
                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //Omformaterar datumet som väljs i DateChoosern så det matchar formatet som datum lagras i databasen.
                String date1 = dFormat.format(valjDatum.getDate());

                Statement stmt = connection.createStatement();

                String KID = ""; //Angivet kommentarID, det man vill ta bort

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

                    stmt.executeUpdate("UPDATE MOTE SET INFO ='" + txtAndraInfo.getText() + "', SAL='" + txtAndraSal.getText() + "', TID='" + txtAndraTid.getText() + "'" + ", DATUM='" + date1 + "' WHERE MOTESID ='" + motesid + "'");

                    lblNotis.setText("Mötet har ändrats");
                    //JOptionPane.showMessageDialog(null, "Mötet har ändrats");

                } else {

                    JOptionPane.showMessageDialog(null, "Du har inte behörighet att ändra mötet");

                }
                lista.removeAllElements();
                fyllComboBoxAnvandare();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }//GEN-LAST:event_btnÄndraMotenActionPerformed

    private void listaMotenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaMotenKeyPressed
        Statement stmt;
        try {
            stmt = connection.createStatement();

            String motesid = listaMoten.getSelectedValue();
            int motesidInt = Integer.parseInt(motesid);

            ResultSet rs2 = stmt.executeQuery("SELECT  INFO, SAL, TID, DATUM FROM MOTE WHERE MOTESID = " + motesidInt + "");

            String info = rs2.getString("INFO");
            String tid = rs2.getString("TID");
            String sal = rs2.getString("SAL");
            Date datum = rs2.getDate("DATUM");

            txtAndraInfo.setText(info);
            txtAndraSal.setText(sal);
            txtAndraTid.setText(tid);
            valjDatum.setDate(datum);

        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_listaMotenKeyPressed

    private void btnValjMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValjMoteActionPerformed
        if (Validering.isJListTomt(listaMoten)) {
            String valtInlagg = (String) listaMoten.getSelectedValue();
            inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));

            btnÄndraMoten.setVisible(true);
            Statement stmt;
            try {
                stmt = connection.createStatement();

                String motesidstring = listaMoten.getSelectedValue();

                motesid = motesidstring.split(" ")[0];

                int motesidInt = Integer.parseInt(motesid);

                ResultSet rs2 = stmt.executeQuery("SELECT INFO, SAL, TID,DATUM FROM MOTE WHERE MOTESID = " + motesidInt + "");
                rs2.next();

                String info = rs2.getString("INFO");
                String tid = rs2.getString("TID");
                String sal = rs2.getString("SAL");
                Date datum = rs2.getDate("DATUM");

                txtAndraInfo.setText(info);
                txtAndraSal.setText(sal);
                txtAndraTid.setText(tid);
                valjDatum.setDate(datum);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnValjMoteActionPerformed
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
    private javax.swing.JButton btnValjMote;
    private javax.swing.JButton btnÄndraMoten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNotis;
    private javax.swing.JList<String> listaMoten;
    private javax.swing.JTextArea txtAndraInfo;
    private javax.swing.JTextField txtAndraSal;
    private javax.swing.JTextField txtAndraTid;
    private com.toedter.calendar.JDateChooser valjDatum;
    // End of variables declaration//GEN-END:variables
}
